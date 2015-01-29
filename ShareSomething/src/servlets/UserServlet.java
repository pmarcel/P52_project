package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Helpers.navigationHelper;
import models.User;
import facades.CategoriesFacade;
import facades.UsersFacade;

/**
 * Servlet implementation class UserManager
 */
@WebServlet(
		description = "gestion des connexion/inscriptions", 
		urlPatterns = { 
				"/connect", 
				"/register"
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = null, password = null, action = null;
		boolean stop = false;
		
		try{
			action = request.getParameter("action");
		  	login = request.getParameter("login");
		  	password = request.getParameter("password");
		}
		catch(NullPointerException e)
		{
			stop = true;
		}
		
		
		//Redirection en cas de mauvais appel
		if(action == null){
			request.setAttribute("error", "Erreur lors de l'appel de la page ! Action == null");
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			return;
		 }
		else if(action.equals("register") && stop)
		{
			request.setAttribute("error", "Erreur lors de la récupération des paramètres");
			navigationHelper.navigateWithCategories(request, response, "register.jsp");
			return;
		}
		else if(stop)
		{
			request.setAttribute("error", "Erreur lors de la récupération des paramètres");
			navigationHelper.navigateWithCategories(request, response, "login.jsp");
			return;
		}
		
		//Traitement des requètes
		
		//Inscription
		if(action.equals("register"))
		{
			if(isConnected(request.getSession(false)))
			{
				request.setAttribute("error", "Erreur : Vous êtes déjà inscrit !");
				navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
				return;
			}
			else
			{
				User user = UsersFacade.create(login, password);
				
				if(user == null)
				{
					request.setAttribute("error", "Erreur : Ce login est déja attribué !");
					navigationHelper.navigateWithCategories(request, response, "register.jsp");
					return;
				}
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("login", user.getLogin());
				request.setAttribute("message", "Inscription réussie");
				navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			}
		}
		//Connexion
		else if(action.equals("connect"))
		{
			User user =UsersFacade.CheckLogin(login, password);
			
			if(isConnected(request.getSession(false)))
			{
				request.setAttribute("error", "Erreur : Vous êtes déjà connecté !");
				navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			}
			else if(user !=null)
			{
				//Création de la session
				HttpSession session = request.getSession(true);    
				session.setAttribute("user", user);
				session.setAttribute("login", user.getLogin());
				request.setAttribute("message", "Connection réussie");
				navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			}
			else
			{
				//redirection avec erreur
				request.setAttribute("error", "Erreur : Login ou mot de passe incorrect");
				navigationHelper.navigateWithCategories(request, response, "login.jsp");
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action;
		
		//CategoriesFacade.InitCategories();
		
		try{
		action = request.getParameterValues("action")[0].trim();
		}
		catch(NullPointerException e)
		{
			action = "connect";
		}
				
		if(isConnected(request.getSession(false))&&!action.equals("disconnect"))
		{
			request.setAttribute("error", "Erreur : Vous êtes déjà connecté !");
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			return;
		}
		
		if( action.equals("register"))
			navigationHelper.navigateWithCategories(request, response, "register.jsp");
		else if(action.equals("connect"))
			navigationHelper.navigateWithCategories(request, response, "login.jsp");
		else if(action.equals("disconnect"))
		{
			HttpSession session = request.getSession(true);    
			session.invalidate();
			request.setAttribute("message", "Déconnexion réussie !");
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
		}
		else
		{
			request.setAttribute("error", "Erreur : action invalide ! "+action);
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
		}
			
		
	}
	
	public static boolean isConnected(HttpSession session)
	{
		User user;
		try{
			user = (User)session.getAttribute("user");
		}
		catch(Exception e)
		{
			return false;
		}
		
		return user != null;
	}
}	
