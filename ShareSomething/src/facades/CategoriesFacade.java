package facades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Category;

public class CategoriesFacade extends BaseFacade{
	@SuppressWarnings("unchecked")
	public static List<Category> list() {
		EntityManager m = getEM();
		Query q = null;
		List<Category> res = new ArrayList<Category>();
		try {
			q = m.createQuery("SELECT e FROM Category e");
		} catch(Exception e) {
			System.err.println("-- ERROR FacadeCategorie.getCategories() -- "+ e.getMessage());
		} finally {
			try {
				res = q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			m.close();
		}
		
		return res;
	}
	
	public static Category getById(int id) {
		EntityManager m = getEM();
		Query q = null;
		Category res = null;
		try {
			q = m.createQuery("SELECT e FROM Category e WHERE id = :id");
			q.setParameter("id", id);
		} catch(Exception e) {
			System.err.println("-- ERROR FacadeCategorie.getCategories() -- "+ e.getMessage());
		} finally {
			try {
				res = (Category) q.getSingleResult();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			m.close();
		}
		
		return res;
	}
}
