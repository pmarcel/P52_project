package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseFacade {
	private EntityManagerFactory emf;
	
	public EntityManagerFactory getEMF (){
		if (emf == null){
			emf = Persistence.createEntityManagerFactory("ShareSomething");
		}
		return emf;
	}
	
	public EntityManager getEM()
	{
		return getEMF().createEntityManager();
	}
}
