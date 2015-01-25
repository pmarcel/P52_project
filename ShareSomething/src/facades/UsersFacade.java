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
	
	public static boolean CheckLogin(String login, String password) {
		EntityManager m = getEM();
		Query q = null;
		boolean res = false;
		
		try {
			q = m.createQuery("SELECT COUNT(e) FROM Users e WHERE login LIKE '" + login + "' AND password = '" + password + "'");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res = ((int) q.getSingleResult()) == 1 ? true : false;		// Si plus d'un r�sultat (ou z�ro), login failed
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			m.close();
		}
		
		return res;
	}
}
