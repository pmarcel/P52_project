package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facades.CategoriesFacade;
import facades.ImagesFacade;
import facades.UsersFacade;
import models.Category;
import models.Image;
import models.User;
import Helpers.navigationHelper;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String criteria = request.getParameter("search_input");
		
		if(criteria == null || criteria.isEmpty() || criteria.equals("*"))
		{
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			return;
		}
				
		List<Image> results = new ArrayList<Image>();
		
		User owner = UsersFacade.getByLogin(criteria);
		
		if(owner != null)
		{
			results = ImagesFacade.SearchByOwner(owner);
		}

		if(results.size() == 0) // Si la recherche par user donne rien, alors on fait une recherche par critère
		{
			results = ImagesFacade.SearchByDescription(criteria);
		}
		
		if(results.size() ==0)
		{
			request.setAttribute("error", "Votre recherche n'a donnée aucun résultat");
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
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
