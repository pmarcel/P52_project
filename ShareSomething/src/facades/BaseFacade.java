package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseFacade {
	protected static EntityManagerFactory emf = null;
	
	protected BaseFacade() {}		// pour éviter de créer une BaseFacade avec EntityManagerFactory
								// non initialisée
	
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
