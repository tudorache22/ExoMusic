package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.CanzoneCRUD;
import it.exolab.interfaces.CanzoneInterface;
import it.exolab.models.Album;
import it.exolab.models.Canzone;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.CanzoneValidazione;

@Stateless
@LocalBean
public class CanzoneController implements CanzoneInterface {

	final static Logger logger = Logger.getLogger(CanzoneController.class);

	@Override
	public Canzone insert(Canzone canzone) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + canzone);

			if (new CanzoneValidazione().canzoneIsValid(canzone)) {
				canzone = new CanzoneCRUD().insert(canzone);
				SqlMapFactory.instance().commitSession();
				return canzone;
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
	public Canzone update(Canzone canzone) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + canzone);
			CanzoneValidazione validazione = new CanzoneValidazione();

			if (validazione.canzoneIsValid(canzone)) {
				CanzoneCRUD crud = new CanzoneCRUD();
				canzone = crud.update(canzone);
				SqlMapFactory.instance().commitSession();
				return canzone;
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
	public Canzone findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			CanzoneCRUD crud = new CanzoneCRUD();
			Canzone canzone = crud.findById(id);
			SqlMapFactory.instance().commitSession();
			return canzone;
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
			CanzoneCRUD crud = new CanzoneCRUD();
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
	public List<Canzone> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			CanzoneCRUD crud = new CanzoneCRUD();
			List<Canzone> listaCanzone = crud.findAll();
			SqlMapFactory.instance().commitSession();
			return listaCanzone;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Canzone> findByAlbum(Album album) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findByAlbum>>>");
			// CanzoneCRUD crud = new CanzoneCRUD();
			List<Canzone> listaCanzone = new CanzoneCRUD().findByAlbum(album);
			SqlMapFactory.instance().commitSession();
			return listaCanzone;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Canzone findInserimento(Canzone canzone) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findInserimento>>>" + canzone);
			CanzoneCRUD crud = new CanzoneCRUD();
			Canzone canzone2 = crud.findInserimento(canzone);
			SqlMapFactory.instance().commitSession();
			return canzone2;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
