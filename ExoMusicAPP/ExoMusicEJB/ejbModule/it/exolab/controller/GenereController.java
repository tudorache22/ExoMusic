package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.GenereCRUD;
import it.exolab.interfaces.GenereInterface;
import it.exolab.models.Genere;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.GenereValidazione;

@Stateless
@LocalBean
public class GenereController implements GenereInterface {

	final static Logger logger = Logger.getLogger(GenereController.class);

	@Override
	public Genere insert(Genere genere) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + genere);
			GenereValidazione validazione = new GenereValidazione();

			if (validazione.genereIsValid(genere)) {
				GenereCRUD crud = new GenereCRUD();
				genere = crud.insert(genere);
				SqlMapFactory.instance().commitSession();
				return genere;
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
	public Genere update(Genere genere) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + genere);
			GenereValidazione validazione = new GenereValidazione();

			if (validazione.genereIsValid(genere)) {
				GenereCRUD crud = new GenereCRUD();
				genere = crud.update(genere);
				SqlMapFactory.instance().commitSession();
				return genere;
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
	public Genere findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			GenereCRUD crud = new GenereCRUD();
			Genere genere = crud.findById(id);
			SqlMapFactory.instance().commitSession();
			return genere;
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
			GenereCRUD crud = new GenereCRUD();
			SqlMapFactory.instance().commitSession();
			crud.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Genere> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			GenereCRUD crud = new GenereCRUD();
			List<Genere> listaGenere = crud.findAll();
			SqlMapFactory.instance().commitSession();
			return listaGenere;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Genere findInserimento(Genere genere) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + genere);
			GenereCRUD crud = new GenereCRUD();
			Genere genere2 = crud.findInserimento(genere);
			SqlMapFactory.instance().commitSession();
			return genere2;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}

	}
}