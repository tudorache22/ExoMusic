package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.UtenteCRUD;
import it.exolab.interfaces.UtenteInterface;
import it.exolab.models.Utente;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.UtenteValidazione;

@Stateless
@LocalBean
public class UtenteController implements UtenteInterface {

	final static Logger logger = Logger.getLogger(UtenteController.class);

	@Override
	public Utente insert(Utente utente) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + utente);
			UtenteValidazione validazione = new UtenteValidazione();
			if (validazione.utenteIsValid(utente)) {
				UtenteCRUD crud = new UtenteCRUD();
				utente = crud.insert(utente);
				SqlMapFactory.instance().commitSession();
				return utente;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Utente update(Utente utente) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + utente);
			UtenteValidazione validazione = new UtenteValidazione();

			if (validazione.utenteIsValid(utente)) {
				UtenteCRUD crud = new UtenteCRUD();
				utente = crud.update(utente);
				SqlMapFactory.instance().commitSession();
				return utente;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Utente findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			UtenteCRUD crud = new UtenteCRUD();
			Utente utente = crud.findById(id);
			SqlMapFactory.instance().commitSession();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}

	}

	@Override
	public void delete(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller delete>>>" + id);
			UtenteCRUD crud = new UtenteCRUD();
			crud.delete(id);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Utente> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			UtenteCRUD crud = new UtenteCRUD();
			List<Utente> listaUtente = crud.findAll();
			SqlMapFactory.instance().commitSession();
			return listaUtente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Utente login(Utente utente) {
		try {
			logger.info("Sei nel controller login>>>" + utente);
			SqlMapFactory.instance().openSession();
			UtenteCRUD crud = new UtenteCRUD();
			utente = crud.login(utente);
			SqlMapFactory.instance().commitSession();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
