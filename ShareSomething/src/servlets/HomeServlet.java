package servlets;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.sql.DriverManager;
import java.util.List;
>>>>>>> ad6e3357c5842e89e69cf8ee920ee1bfd753e214

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;

<<<<<<< HEAD
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

=======
>>>>>>> ad6e3357c5842e89e69cf8ee920ee1bfd753e214
/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ShareSomething");

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Category[] v = (Category[]) em.createQuery("FROM categories", Category.class).getResultList().toArray();
		for (Category c : v) {
		System.out.println(c.getName());
		}
		em.getTransaction().commit();
		em.close();

=======

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ShareSomething");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<Category> l = em.createQuery("FROM categories", Category.class).getResultList();
		for (Category c : l) {
			System.out.println(c.getName());
		}
		em.getTransaction().commit();
		em.close();
		
		request.setAttribute("categories", l);
>>>>>>> ad6e3357c5842e89e69cf8ee920ee1bfd753e214
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ShareSomething");

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<Category> l = em.createQuery("FROM categories", Category.class).getResultList();
		for (Category c : l) {
		System.out.println(c.getName());
		}
		em.getTransaction().commit();
		em.close();
	}

}
