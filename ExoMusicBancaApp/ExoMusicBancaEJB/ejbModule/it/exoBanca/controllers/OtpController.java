package it.exoBanca.controllers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.exoBanca.ejbInterfaces.OtpControllerInterface;
import it.exoBanca.models.Otp;
import it.exoBanca.models.Transazione;
import it.exolab.generatoreOtp.GeneraOtp;

@Stateless(name = "OtpControllerInterface")
@LocalBean
public class OtpController extends BaseController implements OtpControllerInterface {

	final static Logger logger = Logger.getLogger(OtpController.class);

	@Override
	public Otp insert(Otp otp) {
		logger.info("sei nel Otp Controller insert >>>" + otp);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(otp)) {
				otp = entityManager.merge(otp);
			}
			entityManager.persist(otp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	@Override
	public Otp update(Otp otp) {
		logger.info("sei nel Otp Controller update >>>" + otp);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(otp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public Otp findById(Integer idOtp) {
		logger.info("sei nel Otp Controller findById >>>" + idOtp);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Otp otp = new Otp();
			otp = entityManager.find(Otp.class, idOtp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<Otp> findAll() {
		logger.info("sei nel Otp Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Otp> listaOtp = new ArrayList<Otp>();
			Query query = entityManager.createNativeQuery("SELECT * FROM otp");
			listaOtp.addAll((List<Otp>) query.getResultList());
			transaction.commit();
			return listaOtp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void delete(Otp otp) {
		logger.info("sei nel Otp Controller delete >>>" + otp);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(otp) ? otp : entityManager.merge(otp));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}

	public Otp nuovoOtp(Transazione transazione) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			Otp otp = creaOtp(transazione);
			logger.info("sei nel Otp Controller insert >>>" + otp);
			transaction.begin();
			if (!entityManager.contains(otp)) {
				otp = entityManager.merge(otp);
			}
			entityManager.persist(otp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public Otp creaOtp(Transazione transazione) throws InvalidKeyException, NoSuchAlgorithmException {
		Otp otp = new Otp();
		otp.setCodice(new GeneraOtp().generator());
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

		otp.setCreazione(out);
//		otp.setScadenza(otp.getCreazione().plusDays(1));
		otp.setStato("attivo");
		otp.setTransazione(transazione);
		return otp;

	}

//	public Otp findOtp(String codice) {
//		Utente utenteTrovato;
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		logger.info("sei nel controllerOtp findOtp >>>" + codice);
//
//		try {
//			transaction.begin();
//			Query query = entityManager.createQuery("Select o FROM Otp u WHERE o.codice_otp = :codiceOtp");
//			query.setParameter("codiceOtp", codice);
//			utenteTrovato = (Utente) query.getSingleResult();
//			System.out.println(utenteTrovato);
//			transaction.commit();
//			return utenteTrovato;
//		} catch (Exception e) {
//			e.printStackTrace();
//			transaction.rollback();
//			return null;
//		} finally {
//			entityManager.close();
//		}
//	}
}
