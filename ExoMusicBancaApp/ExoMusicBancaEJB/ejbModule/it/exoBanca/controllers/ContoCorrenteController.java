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

import it.exoBanca.ejbInterfaces.ContoCorrenteControllerInterface;
import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;
import it.exolab.utility.ContoCorrenteUtility;
import it.exolab.validazioni.ContoCorrenteValidazione;
import it.exolab.validazioni.UtenteValidazione;

@Stateless(name = "ContoCorrenteControllerInterface")
@LocalBean
public class ContoCorrenteController extends BaseController implements ContoCorrenteControllerInterface {

	final static Logger logger = Logger.getLogger(ContoCorrenteController.class);

	@Override
	public ContoCorrente insert(Utente utente) {
		logger.info("sei nel ContoCorrente Controller insert per la persona: >>>" + utente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new UtenteValidazione().utenteIsValid(utente)){
		try {
			transaction.begin();
			ContoCorrente contoCorrente = new ContoCorrenteUtility().getContoCorrente(utente);
			entityManager.persist(contoCorrente);
			transaction.commit();
			return contoCorrente;
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
	public ContoCorrente update(ContoCorrente contoCorrente) {
		logger.info("sei nel ContoCorrente Controller update >>>" + contoCorrente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(new ContoCorrenteValidazione().contoCorrenteIsValid(contoCorrente)) {
		try {
			transaction.begin();
			entityManager.merge(contoCorrente);
			transaction.commit();
			return contoCorrente;
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
	public ContoCorrente findById(Integer idContoCorrente) {
		logger.info("sei nel ContoCorrente Controller findById >>>" + idContoCorrente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			ContoCorrente contoCorrente = new ContoCorrente();
			contoCorrente = entityManager.find(ContoCorrente.class, idContoCorrente);
			transaction.commit();
			return contoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<ContoCorrente> findAll() {
		logger.info("sei nel ContoCorrente Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<ContoCorrente> listaConti = new ArrayList<ContoCorrente>();
			Query query = entityManager.createNativeQuery("SELECT * FROM conto_corrente");
			listaConti.addAll((List<ContoCorrente>) query.getResultList());
			transaction.commit();
			return listaConti;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void delete(ContoCorrente contoCorrente) {
		logger.info("sei nel ContoCorrente Controller delete >>>" + contoCorrente);

		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager
					.remove(entityManager.contains(contoCorrente) ? contoCorrente : entityManager.merge(contoCorrente));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}

	@Override
	public Utente findByConto(ContoCorrente conto) {
		ContoCorrente contoTrovato;
		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		logger.info("sei nel findByIdUtente ContoCorrente >>>" + conto);

		try {
			transaction.begin();
			String query2 = "Select u FROM Utente AS u JOIN ContoCorrente AS c ON u.idUtente = c.utente.idUtente WHERE c.idContoCorrente = :idConto";
			Query query = entityManager.createQuery(query2,Utente.class);
			query.setParameter("idConto", conto.getIdContoCorrente());
			Utente utenteTrovato = (Utente) query.getSingleResult();
			logger.info(utenteTrovato);
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

	public ContoCorrente findByNumeroConto(String numeroConto) {
		ContoCorrente contoTrovato;
		EntityManager entityManager = getEntityManager();
		entityManager= controlloEM(entityManager);
		EntityTransaction transaction = entityManager.getTransaction();
		logger.info("sei nel findByIdUtente ContoCorrente >>>" + numeroConto);

		try {
			transaction.begin();
			Query query = entityManager
					.createQuery("Select c FROM ContoCorrente c WHERE c.numeroConto = :numeroConto");
			query.setParameter("numeroConto", numeroConto);
			contoTrovato = (ContoCorrente) query.getSingleResult();
			logger.info(contoTrovato);
			transaction.commit();
			return contoTrovato;
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
