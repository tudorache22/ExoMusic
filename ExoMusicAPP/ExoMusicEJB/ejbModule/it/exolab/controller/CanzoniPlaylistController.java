package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.CanzoniPlaylistCRUD;
import it.exolab.interfaces.CanzoniPlaylistInterface;
import it.exolab.models.Canzone;
import it.exolab.models.CanzoniPlaylist;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.CanzonePlaylistValidazione;

@Stateless
@LocalBean
public class CanzoniPlaylistController implements CanzoniPlaylistInterface {

	final static Logger logger = Logger.getLogger(CanzoniPlaylistController.class);

	@Override
	public CanzoniPlaylist insert(CanzoniPlaylist canzoniPlaylist) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + canzoniPlaylist);
			// CanzonePlaylistValidazione validazione = new CanzonePlaylistValidazione();

			if (new CanzonePlaylistValidazione().canzoneIsValid(canzoniPlaylist)) {
				// CanzoniPlaylistCRUD crud = new CanzoniPlaylistCRUD();
				canzoniPlaylist = new CanzoniPlaylistCRUD().insert(canzoniPlaylist);
				SqlMapFactory.instance().commitSession();
				return canzoniPlaylist;
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
	public CanzoniPlaylist update(CanzoniPlaylist canzoniPlaylist) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + canzoniPlaylist);
			CanzonePlaylistValidazione validazione = new CanzonePlaylistValidazione();

			if (validazione.canzoneIsValid(canzoniPlaylist)) {
				CanzoniPlaylistCRUD crud = new CanzoniPlaylistCRUD();
				canzoniPlaylist = crud.update(canzoniPlaylist);
				SqlMapFactory.instance().commitSession();
				return canzoniPlaylist;
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
	public CanzoniPlaylist findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			CanzoniPlaylistCRUD crud = new CanzoniPlaylistCRUD();
			CanzoniPlaylist canzoniPlaylist = crud.findById(id);
			SqlMapFactory.instance().commitSession();
			return canzoniPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}

	}

	@Override
	public void delete(CanzoniPlaylist canzonePlaylist) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller delete>>>" + canzonePlaylist);
			CanzoniPlaylistCRUD crud = new CanzoniPlaylistCRUD();
			crud.deleteCanzone(canzonePlaylist);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<CanzoniPlaylist> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			CanzoniPlaylistCRUD crud = new CanzoniPlaylistCRUD();
			List<CanzoniPlaylist> listaCanzoniPlaylist = crud.findAll();
			SqlMapFactory.instance().commitSession();
			return listaCanzoniPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Canzone> findAllById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller canzoniPlaylist findAllById>>>" + id);
			CanzoniPlaylistCRUD crud = new CanzoniPlaylistCRUD();
			List<Canzone> listaCanzoniPlaylist = crud.findAllById(id);
			SqlMapFactory.instance().commitSession();
			return listaCanzoniPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
