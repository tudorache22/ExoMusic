package it.exoBanca.EntityManager;

import javax.persistence.EntityManager;

public interface EntityManagerProvider {

	EntityManager getEntityManager();
}
