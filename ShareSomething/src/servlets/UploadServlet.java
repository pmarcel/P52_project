package servlets;
 
import java.io.File;
import java.io.IOException;
 
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Helpers.navigationHelper;
import models.Category;
import models.User;
import facades.CategoriesFacade;
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
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
			return;
    	}
    	else
    	{
			navigationHelper.navigateWithCategories(request, response, "upload.jsp");
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
			navigationHelper.navigateWithCategoriesAndAllImages(request, response, "index.jsp");
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
        long category_id = 0;
        
        try
        {
        	category_id = Long.parseLong(request.getParameter("category"));
        	description = request.getParameter("description");
        }
        catch(Exception e)
        {
        	description = "";
        }
        for (Part part : request.getParts()) {
            if(extractFileName(part)!="") {
	        	imageName = extractFileName(part);
	
	            part.write(savePath + File.separator + filecode+imageName);
            }
        }
 
        ImagesFacade.Create(imageName,					// nom de l'image 
        		"''" + description + "''", 							// description
        		(User)request.getSession().getAttribute("user"), // id de l'utilisateur
        		"/ShareSomething/upload/"+filecode+imageName, 			// lien
        		CategoriesFacade.getById(category_id));	// cat�gorie.
        
        request.setAttribute("message", "Upload has been done successfully!");
		navigationHelper.navigateWithCategories(request, response, "upload.jsp");
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