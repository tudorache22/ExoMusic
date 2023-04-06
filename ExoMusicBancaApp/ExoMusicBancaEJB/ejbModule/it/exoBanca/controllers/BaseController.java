package it.exoBanca.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.exoBanca.EntityManager.EntityManagerProvider;

public class BaseController implements EntityManagerProvider {

	protected static String entityProjectName = "ExoMusicBancaModel";

	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(entityProjectName);
	private final EntityManager entityManager;

	public BaseController() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void closeEntityManager() {
		entityManager.close();
	}

}
