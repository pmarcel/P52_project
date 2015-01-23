package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if(request.getParameter("action") == "login")
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(request.getParameter("action") == "register")
		{
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub
	}
}	
