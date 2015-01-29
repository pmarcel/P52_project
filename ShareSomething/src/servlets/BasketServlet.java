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
@WebServlet("/BasketServlet")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("action") == "delete") {
			long id = (long) request.getAttribute("image");
			
			((Cart) request.getSession().getAttribute("cart")).removeImageById(id);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (request.getAttribute("action") == "add") {
			System.out.println("add");
			long id = (long) request.getAttribute("image");
			
			((Cart) request.getSession().getAttribute("cart")).removeImageById(id);
			
			request.getRequestDispatcher("basket.jsp").forward(request, response);
		} else {
			List<Category> list_categories = CategoriesFacade.list();
			request.setAttribute("categories", list_categories);
					
			List<Image> list_images = ((Cart) request.getSession().getAttribute("cart")).list();
			request.setAttribute("images", list_images);
			
			request.getRequestDispatcher("basket.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new CategoriesFacade();
		List<Category> list_categories = CategoriesFacade.list();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		for(Category c : list_categories)
		{
			out.println("<p>"+c.getName()+"</p>");
		}
	}

}
