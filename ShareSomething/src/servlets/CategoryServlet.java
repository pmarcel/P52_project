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

import models.*;
import facades.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> list_categories = CategoriesFacade.list();
		
		if(request.getParameterValues("id")[0] != null)
		{
		List<Image> list_pictures = ImagesFacade.SearchByCategory(CategoriesFacade.getById(Integer.parseInt(request.getParameterValues("id")[0])));
		
		request.setAttribute("categories", list_categories);
		request.setAttribute("pictures", list_pictures);
		request.getRequestDispatcher("category.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Inutile pour cette servlet
	}

}
