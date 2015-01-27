package facades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.User;

public class UsersFacade extends BaseFacade {	
	@SuppressWarnings("unchecked")
	public static List<User> list() {
		EntityManager m = getEM();
		Query q = null;
		List<User> res = new ArrayList<User>();
		try {
			q = m.createQuery("SELECT e FROM User e");
		} catch(Exception e) {
			System.err.println("-- ERROR UsersFacade.getUsers() -- "+ e.getMessage());
		} finally {
			try {
				res = (ArrayList<User>) q.getResultList();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			m.close();
		}
		
		return res;
	}
	
	public static User create(String login, String password) {
		EntityManager m = getEM();
		Query q = null;
		User res = null;
		
		m.getTransaction().begin();
		
		try {
			q = m.createQuery("SELECT COUNT(e) FROM User e WHERE e.login LIKE :login");
			q.setParameter("login", login);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			long nb = 1;
			try {
				nb = (long) q.getSingleResult();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			if (nb == 0) {
					res = new User();
					res.setLogin(login);
					res.setPassword(password);
					m.persist(res);
			}
		}
		
		m.getTransaction().commit();

		return res;
	}
	
	public static User read(int id) {
		EntityManager m = getEM();
		Query q = null;
		User res = null;
		
		try {
			q = m.createQuery("Select e FROM User e WHERE id = " + Integer.toString(id));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = (User) q.getSingleResult();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			m.close();
		}
		
		return res;
	}
	
	/**
	 * Renvoie Le user si la connexion s'est bien pass�e
	 * @param login
	 * @param password
	 * @return Le user ou null
	 */
	public static User CheckLogin(String login, String password) {
		EntityManager m = getEM();
		Query q = null;
		User res = null;
		
		try {
			q = m.createQuery("SELECT e FROM Users e WHERE login LIKE '" + login + "' AND password = '" + password + "'");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = (User) q.getSingleResult();		// Si plus d'un r�sultat (ou z�ro), login failed
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			m.close();
		}
		
		return res;
	}
}
