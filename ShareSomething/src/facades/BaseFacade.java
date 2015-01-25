package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseFacade {
	protected static EntityManagerFactory emf = null;
	
	protected BaseFacade() {}		// pour �viter de cr�er une BaseFacade avec EntityManagerFactory
								// non initialis�e
	
	public static EntityManagerFactory getEMF() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("ShareSomething");
		}
		return emf;
	}
	
	public static EntityManager getEM() {
		return getEMF().createEntityManager();
	}
}
