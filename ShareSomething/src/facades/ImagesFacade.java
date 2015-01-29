package facades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Category;
import models.Image;
import models.User;

public class ImagesFacade extends BaseFacade {
	@SuppressWarnings("unchecked")
	public static List<Image> getImages() {
		EntityManager m = getEM();
		Query q = null;
		List<Image> res = new ArrayList<Image>();
		try {
			q = m.createQuery("SELECT e FROM Image e");
		} catch(Exception e) {
			System.out.println("-- ERROR FacadeCategorie.getCategories() -- "+ e.getMessage());
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
	
	
	
	public static Image Create(String name, String description, User owner, String link) {
		EntityManager m = getEM();
		Image res = null;
		
		m.getTransaction().begin();
		
		try {
			res = new Image();
			res.setName(name);
			res.setDescription(description);
			res.setOwner(owner);
			res.setLink(link);
			m.persist(res);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		m.getTransaction().commit();

		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Image> SearchByName(String name) {
		EntityManager m = getEM();
		List<Image> res = new ArrayList<Image>();
		Query q = null;
		
		try {
			q = m.createQuery("SELECT e FROM Image e WHERE name LIKE '%:name%'");
			q.setParameter(":name", name);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = (ArrayList<Image>) q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Image> SearchByCategory(Category category) {
		EntityManager m = getEM();
		List<Image> res = new ArrayList<Image>();
		Query q = null;
		
		try {
			q = m.createQuery("SELECT e FROM Image e WHERE category = :category");
			q.setParameter("category", category);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = (ArrayList<Image>) q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return res;
	}
}
