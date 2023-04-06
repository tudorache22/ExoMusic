package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.exoBanca.ejbInterfaces.TransazioneControllerInterface;
import it.exoBanca.models.Transazione;

@Stateless(name = "TransazioneControllerInterface")
@LocalBean
public class TransazioneController extends BaseController implements TransazioneControllerInterface {

	final static Logger logger = Logger.getLogger(TransazioneController.class);

	@Override
	public Transazione insert(Transazione transazione) {
		logger.info("sei nel Transazione Controller insert >>>" + transazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(transazione)) {
				transazione = entityManager.merge(transazione);
			}
			entityManager.persist(transazione);
			transaction.commit();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	@Override
	public Transazione update(Transazione transazione) {
		logger.info("sei nel Transazione Controller update >>>" + transazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(transazione);
			transaction.commit();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public Transazione findById(Integer idTransazione) {
		logger.info("sei nel Transazione Controller findById >>>" + idTransazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Transazione transazione = new Transazione();
			transazione = entityManager.find(Transazione.class, idTransazione);
			transaction.commit();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<Transazione> findAll() {
		logger.info("sei nel Transazione Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Transazione> listaTransazioni = new ArrayList<Transazione>();
			Query query = entityManager.createNativeQuery("SELECT * FROM transazione");
			listaTransazioni.addAll((List<Transazione>) query.getResultList());
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
	public void delete(Transazione transazione) {
		logger.info("sei nel Transazione Controller delete >>>" + transazione);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(transazione) ? transazione : entityManager.merge(transazione));
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
