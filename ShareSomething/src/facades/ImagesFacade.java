package facades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Image;

public class ImagesFacade extends BaseFacade {
	@SuppressWarnings("unchecked")
	public static List<Image> getImages() {
		EntityManager m = getEM();
		Query q = null;
		List<Image> res = new ArrayList<Image>();
		try {
			q = m.createQuery("SELECT e FROM Category e");
		} catch(Exception e) {
			System.out.println("-- ERROR FacadeCategorie.getCategories() -- "+ e.getMessage());
		} finally {
			res = (ArrayList<Image>) q.getResultList();
			m.close();
		}
		
		return res;
	}
}
