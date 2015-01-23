package facades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Category;

public class CategoriesFacade extends BaseFacade{
	
	public List<Category> getCategories() {
		EntityManager m = this.getEM();
		Query q = null;
		List<Category> res;
		try {
			q = m.createQuery("SELECT e FROM Category e");
		} catch(Exception e) {
			System.out.println("-- ERROR FacadeCategorie.getCategories() -- "+ e.getMessage());
		} finally {
			res = (List<Category>) q.getResultList();
			m.close();
		}
		
		return res;
	}
}
