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
	
	public static Image Create(String name, String description, User owner, String link, Category category) {
		EntityManager m = getEM();
		Image res = null;
		
		m.getTransaction().begin();
		
		System.out.println(category.getId() + "\n" + category.getName() + "\n" + category.getParent());
		
		try {
			res = new Image();
			res.setName(name);
			res.setDescription(description);
			res.setOwner(owner);
			res.setLink(link);
			res.setCategory(category);
			m.persist(res);
			System.out.println("categorie après persistance : " + res.getCategory().getName());

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
			q = m.createQuery("SELECT e FROM Image e WHERE e.name LIKE :name");
			q.setParameter("name", "%"+name+"%");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Image> SearchByDescription(String keyword) {
		EntityManager m = getEM();
		List<Image> res = new ArrayList<Image>();
		Query q = null;
		
		try {
			q = m.createQuery("SELECT e FROM Image e WHERE e.description LIKE :keyword");
			q.setParameter("keyword", "%"+keyword+"%");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = q.getResultList();
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
			q = m.createQuery("SELECT e FROM Image e WHERE e.category = :category");
			q.setParameter("category", category);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res =  q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return res;
	}
	
<<<<<<< HEAD
	public static Image searchById(long id) {
		EntityManager m = getEM();
		Image res = null;
		Query q = null;
		
		try {
			q = m.createQuery("SELECT e FROM Image e WHERE e.id = :id");
			q.setParameter("id", id);
=======
	@SuppressWarnings("unchecked")
	public static List<Image> SearchByOwner(User user) {
		EntityManager m = getEM();
		List<Image> res = new ArrayList<Image>();
		Query q = null;
		
		try {
			q = m.createQuery("SELECT e FROM Image e WHERE e.owner = :user");
			q.setParameter("user", user);
>>>>>>> 7339b77aea865730917f36e3cd6c0aaca40aba07
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
<<<<<<< HEAD
				res = (Image) q.getSingleResult();
=======
				res = q.getResultList();
>>>>>>> 7339b77aea865730917f36e3cd6c0aaca40aba07
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Image> SearchByUserAndKeyword(User user, String keyword) {
		EntityManager m = getEM();
		List<Image> res = new ArrayList<Image>();
		Query q = null;
		
		try {
			q = m.createQuery("SELECT e FROM Image e WHERE e.owner = :user AND e.description LIKE :keyword");
			q.setParameter("user", user);
			q.setParameter("keyword", "%"+keyword+"%");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return res;
	}
}
