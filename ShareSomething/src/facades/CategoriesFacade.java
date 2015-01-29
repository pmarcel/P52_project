package facades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Category;
import models.User;

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
	
	public static Category getById(long id) {
		
		EntityManager m = getEM();
		Query q = null;
		
		Category categ = null;
		try {
			q = m.createQuery("SELECT e FROM Category e WHERE e.id = :id");
			q.setParameter("id", id);
		} catch (Exception e) {
			System.err.println(e.getMessage() + "GetById categorie");
		} finally {
			try {
				categ = (Category) q.getSingleResult();		// Si plus d'un r�sultat (ou z�ro), login failed
			} catch (Exception e) {
				System.err.println("User not found");
			}
			m.close();
		}
		
		return categ;
	}


	public static void InitCategories()
	{
		System.out.println("Initialisation catégories");
		EntityManager m = getEM();
		
		m.getTransaction().begin();
		
		Category c = new Category();
		c.setName("Artistique");
		m.persist(c);
		
		c = new Category();
		c.setName("Photographique");
		m.persist(c);
		
		c = new Category();
		c.setName("Animaliste");
		m.persist(c);
		
	    c = new Category();
		c.setName("Naturiste");
		m.persist(c);
		
		Category ca = new Category();
		ca.setName("Fleurs");
		ca.setParent(c);
		m.persist(ca);
		
		ca= new Category();
		ca.setName("Agriculture biologique");
		ca.setParent(c);
		m.persist(ca);
		
		m.getTransaction().commit();
		m.close();
	}
}
