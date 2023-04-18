package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.exoBanca.ejbInterfaces.AnagraficaControllerInterface;
import it.exoBanca.models.Anagrafica;
import it.exolab.validazioni.AnagraficaValidazione;

@Stateless(name = "AnagraficaControllerInterface")
@LocalBean
public class AnagraficaController extends BaseController implements AnagraficaControllerInterface {

	final static Logger logger = Logger.getLogger(AnagraficaController.class);

	@Override
	public Anagrafica insert(Anagrafica anagrafica) {
		logger.info("sei nel Anagrafica Controller insert >>>" + anagrafica);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new AnagraficaValidazione().anagraficaIsValid(anagrafica)) {
		try {
			transaction.begin();
			if (!entityManager.contains(anagrafica)) {
				anagrafica = entityManager.merge(anagrafica);
			}
			entityManager.persist(anagrafica);
			transaction.commit();
			return anagrafica;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
		}
		else {
			return null;
		}
	}

	@Override
	public Anagrafica update(Anagrafica anagrafica) {
		logger.info("sei nel Anagrafica Controller update >>>" + anagrafica);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new AnagraficaValidazione().anagraficaIsValid(anagrafica)) {
		try {
			transaction.begin();
			entityManager.merge(anagrafica);
			transaction.commit();
			return anagrafica;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
		}
		else {
			return null;
		}
	}

	@Override
	public Anagrafica findById(Integer idAnagrafica) {
		logger.info("sei nel Anagrafica Controller findById >>>" + idAnagrafica);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Anagrafica anagrafica = new Anagrafica();
			anagrafica = entityManager.find(Anagrafica.class, idAnagrafica);
			transaction.commit();
			return anagrafica;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<Anagrafica> findAll() {
		logger.info("sei nel Anagrafica Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Anagrafica> listaTransazioni = new ArrayList<Anagrafica>();
			Query query = entityManager.createNativeQuery("SELECT * FROM anagrafica");
			listaTransazioni.addAll((List<Anagrafica>) query.getResultList());
			transaction.commit();
			return listaTransazioni;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void delete(Anagrafica anagrafica) {
		logger.info("sei nel Anagrafica Controller delete >>>" + anagrafica);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(anagrafica) ? anagrafica : entityManager.merge(anagrafica));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}
	
	public EntityManager controlloEM(EntityManager entityManager) {
		if(entityManager.isOpen() == true) {
			return entityManager;
		}
		else {
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("ExoMusicBancaModel");
			entityManager=entityManagerFactory.createEntityManager();
			return entityManager;
		}
	}

}
