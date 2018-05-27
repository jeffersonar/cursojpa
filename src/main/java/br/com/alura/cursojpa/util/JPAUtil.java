package br.com.alura.cursojpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("financas");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
