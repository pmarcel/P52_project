package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.util.List;






import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helpers.navigationHelper;
import models.*;
import facades.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/AdvancedSearchServlet")
public class AdvancedSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		navigationHelper.navigateWithCategories(request, response, "advancedsearch.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String author = request.getParameter("author");
		
		if(keyword == null && author == null)
		{
			request.setAttribute("error", "Erreur : Veuillez entrer vos critères de recherche");
			navigationHelper.navigateWithCategories(request, response, "advancedsearch.jsp");
			return;
		}
		
		List<Image> results = new ArrayList<Image>();
		
		if(keyword == null)
		{
			//recherche par autheur
			User user  = UsersFacade.getByLogin(author);
			if(user != null)
				results = ImagesFacade.SearchByOwner(user);
		}
		
		else if(author == null)
		{
			//recherche par critère
			results = ImagesFacade.SearchByDescription(keyword);
		}
		else
		{
			//recherche par critère et par autheur (combiné)
			User user  = UsersFacade.getByLogin(author);
			results = ImagesFacade.SearchByUserAndKeyword(user, keyword);
		}
		
		if(results.size() ==0)
		{
			request.setAttribute("error", "Votre recherche n'a donnée aucun résultat");
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "advancedsearch.jsp");
		}
		else
		{
			List<Category> list_categories = CategoriesFacade.list();
			request.setAttribute("categories", list_categories);
			request.setAttribute("pictures", results);
			request.setAttribute("message", results.size() +" résultat(s) trouvé(s)");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
