package servlets;
 
import java.io.File;
import java.io.IOException;
 
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.User;
import facades.ImagesFacade;
 
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "upload";
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	if(!UserServlet.isConnected(request.getSession()))
    	{
    		request.setAttribute("error", "Erreur : Vous devez être connecté pour upload des images");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
    	}
    	else
    	{
    		request.getRequestDispatcher("upload.jsp").forward(request, response);
    	}
	}
	
    /**
     * handles file upload
     */
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	if(!UserServlet.isConnected(request.getSession()))
    	{
    		request.setAttribute("error", "Erreur : Vous devez être connecté pour upload des images");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
    	}
    	
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator +SAVE_DIR;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        String filecode = new Date().getTime()+"";
        
        String imageName="";
        String description = null;
        
        try
        {
        	description = request.getParameter("description");
        }
        catch(Exception e)
        {
        	description = "";
        }
        for (Part part : request.getParts()) {
            imageName = extractFileName(part);
            part.write(savePath + File.separator + filecode+imageName);
        }
 
        ImagesFacade.Create(imageName, description, (User)request.getSession().getAttribute("user"), "/upload/"+filecode+imageName);
        request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);
    }
 
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}