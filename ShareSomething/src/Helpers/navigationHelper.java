package Helpers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Image;
import facades.CategoriesFacade;
import facades.ImagesFacade;

public class navigationHelper {
	
	public static void navigateWithCategories(HttpServletRequest request, HttpServletResponse response, String targetJSP)
	{
		List<Category> list_categories = CategoriesFacade.list();
		request.setAttribute("categories", list_categories);
		try {
			request.getRequestDispatcher(targetJSP).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void navigateWithCategoriesAndAllImages(HttpServletRequest request, HttpServletResponse response, String targetJSP)
	{
		List<Category> list_categories = CategoriesFacade.list();
		List<Image> list_pictures = ImagesFacade.getImages();

		request.setAttribute("categories", list_categories);
		request.setAttribute("pictures", list_pictures);

		try {
			request.getRequestDispatcher(targetJSP).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
