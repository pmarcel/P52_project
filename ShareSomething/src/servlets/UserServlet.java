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

import facades.UsersFacade;

/**
 * Servlet implementation class UserManager
 */
@WebServlet(
		description = "gestion des connexion/inscriptions", 
		urlPatterns = { 
				"/login", 
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
			action = request.getParameter("submit");
		  	login = request.getParameter("login");
		  	password = request.getParameter("password");
		}
		catch(NullPointerException e)
		{
			stop = true;
		}
		
		
		//Redirection en cas de mauvais appel
		if(action == null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		if(action == "register" && stop)
		{
			request.getRequestDispatcher("register.jsp").forward(request, response);;
		}
		else if(stop)
		{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
		//Traitement des requètes
		
		//Inscription
		if(action == "register")
		{
			
		}
		//Connexion
		else if(action =="connect")
		{
			if(UsersFacade.CheckLogin(login, password))
			{
				//Création de la session
				HttpSession session = request.getSession(true);    
				session.setAttribute("login", login);
				request.setAttribute("message", "Connection réussie");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				//redirection avec erreur
				request.setAttribute("error", "Erreur : Login ou mot de passe incorrect");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action;
		
		try{
		action = request.getParameterValues("action")[0].trim();
		}
		catch(NullPointerException e)
		{
			action = "connect";
		}
				
		if( action.equals("register"))
			request.getRequestDispatcher("register.jsp").forward(request, response);
		else if(action.equals("connect"))
			request.getRequestDispatcher("login.jsp").forward(request, response);
		else
			response.getWriter().write(action);
			
		
	}
}	
