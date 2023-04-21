package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.lowagie.text.Document;

import it.exoBanca.ejbInterfaces.TransazioneControllerInterface;
import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Transazione;
import it.exoBanca.models.Utente;
import it.exolab.validazioni.TransazioneValidazione;

@Stateless(name = "TransazioneControllerInterface")
@LocalBean
public class TransazioneController extends BaseController implements TransazioneControllerInterface {

	final static Logger logger = Logger.getLogger(TransazioneController.class);

	@Override
	public Transazione insert(Transazione transazione) {
		logger.info("sei nel Transazione Controller insert >>>" + transazione);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new TransazioneValidazione().transazioneIsValid(transazione)) {
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
		else {
			return null;
		}
	}

	@Override
	public Transazione update(Transazione transazione) {
		logger.info("sei nel Transazione Controller update >>>" + transazione);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new TransazioneValidazione().transazioneIsValid(transazione)) {
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
		else {
			return null;
		}
	}

	@Override
	public Transazione findById(Integer idTransazione) {
		logger.info("sei nel Transazione Controller findById >>>" + idTransazione);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
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
		entityManager= controlloEM(entityManager);
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
		entityManager= controlloEM(entityManager);
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

	@Override
	public Transazione confermaTransazione(Transazione transazione) {
		logger.info("sei nel Transazione Controller confermaTransazione >>>" + transazione);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			ContoCorrente contoCorrente= transazione.getUtente().getContoCorrentes().get(1);
			float nuovoSaldo=0;
			
			switch(transazione.getTipoTransazione()) {
			case "deposito":  nuovoSaldo= contoCorrente.getSaldo() + transazione.getImporto(); break;
			case "prelievo":  nuovoSaldo= contoCorrente.getSaldo() - transazione.getImporto(); break;
			case "bonificoEntrata":  nuovoSaldo= contoCorrente.getSaldo() + transazione.getImporto(); break;
			case "bonificoUscita":  nuovoSaldo= contoCorrente.getSaldo() - transazione.getImporto(); break;
			case "abbonamento":	 nuovoSaldo= contoCorrente.getSaldo() - transazione.getImporto(); break;
			default: nuovoSaldo=0;
			}
			
			contoCorrente.setSaldo(nuovoSaldo);
			entityManager.merge(transazione);
			entityManager.merge(contoCorrente);
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
	

}
