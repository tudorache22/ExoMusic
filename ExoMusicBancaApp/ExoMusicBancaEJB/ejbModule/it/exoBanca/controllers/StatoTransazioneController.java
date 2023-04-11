package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.exoBanca.ejbInterfaces.StatoTransazioneInterface;
import it.exoBanca.models.StatoTransazione;

public class StatoTransazioneController extends BaseController implements StatoTransazioneInterface {

	final static Logger logger = Logger.getLogger(StatoTransazioneController.class);

	@Override
	public StatoTransazione insert(StatoTransazione StatoTransazione) {
		logger.info("sei nel StatoTransazione Controller insert >>>" + StatoTransazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(StatoTransazione)) {
				StatoTransazione = entityManager.merge(StatoTransazione);
			}
			entityManager.persist(StatoTransazione);
			transaction.commit();
			return StatoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	@Override
	public StatoTransazione update(StatoTransazione StatoTransazione) {
		logger.info("sei nel StatoTransazione Controller update >>>" + StatoTransazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(StatoTransazione);
			transaction.commit();
			return StatoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public StatoTransazione findById(Integer idStatoTransazione) {
		logger.info("sei nel StatoTransazione Controller findById >>>" + idStatoTransazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			StatoTransazione StatoTransazione = new StatoTransazione();
			StatoTransazione = entityManager.find(StatoTransazione.class, idStatoTransazione);
			transaction.commit();
			return StatoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<StatoTransazione> findAll() {
		logger.info("sei nel StatoTransazione Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<StatoTransazione> listaTransazioni = new ArrayList<StatoTransazione>();
			Query query = entityManager.createNativeQuery("SELECT * FROM StatoTransazione");
			listaTransazioni.addAll((List<StatoTransazione>) query.getResultList());
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
	public void delete(StatoTransazione StatoTransazione) {
		logger.info("sei nel StatoTransazione Controller delete >>>" + StatoTransazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(StatoTransazione) ? StatoTransazione : entityManager.merge(StatoTransazione));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}
	
	
}