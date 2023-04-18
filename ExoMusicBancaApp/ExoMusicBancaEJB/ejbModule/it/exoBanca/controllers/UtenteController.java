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

import it.exoBanca.ejbInterfaces.UtenteControllerInterface;
import it.exoBanca.models.Utente;
import it.exolab.validazioni.UtenteValidazione;

@Stateless(name = "UtenteControllerInterface")
@LocalBean
public class UtenteController extends BaseController implements UtenteControllerInterface {

	final static Logger logger = Logger.getLogger(UtenteController.class);

	@Override
	public Utente insert(Utente utente) {
		logger.info("sei nel Utente Controller insert >>>" + utente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new UtenteValidazione().utenteIsValid(utente)) {
		try {
			transaction.begin();
			if (!entityManager.contains(utente)) {
				utente = entityManager.merge(utente);
			}
			entityManager.persist(utente);
			transaction.commit();
			return utente;
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
	public Utente update(Utente utente) {
		logger.info("sei nel Utente Controller update >>>" + utente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new UtenteValidazione().utenteIsValid(utente)) {
		try {
			transaction.begin();
			entityManager.merge(utente);
			transaction.commit();
			return utente;
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
	public Utente findById(Integer idUtente) {
		logger.info("sei nel Utente Controller findById >>>" + idUtente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Utente utente = new Utente();
			utente = entityManager.find(Utente.class, idUtente);
			transaction.commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<Utente> findAll() {
		logger.info("sei nel Utente Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Utente> listaUtenti = new ArrayList<Utente>();
			Query query = entityManager.createNativeQuery("SELECT * FROM utente");
			listaUtenti.addAll((List<Utente>) query.getResultList());
			transaction.commit();
			return listaUtenti;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void delete(Utente utente) {
		logger.info("sei nel Utente Controller delete >>>" + utente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(utente) ? utente : entityManager.merge(utente));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}

	public Utente findByEmailPassword(Utente utente) {
		Utente utenteTrovato;
		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		logger.info("sei nel Utente login >>>" + utente);

		try {
			transaction.begin();
			Query query = entityManager
					.createQuery("Select u FROM Utente u WHERE u.email = :email And u.password = :password");
			query.setParameter("email", utente.getEmail());
			query.setParameter("password", utente.getPassword());
			utenteTrovato = (Utente) query.getSingleResult();
			System.out.println(utenteTrovato);
			transaction.commit();
			return utenteTrovato;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
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
