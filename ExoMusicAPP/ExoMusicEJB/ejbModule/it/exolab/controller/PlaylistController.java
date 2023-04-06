package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.PlaylistCRUD;
import it.exolab.interfaces.PlaylistInterface;
import it.exolab.models.Playlist;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.PlaylistValidazione;

@Stateless
@LocalBean
public class PlaylistController implements PlaylistInterface {

	final static Logger logger = Logger.getLogger(PlaylistController.class);

	@Override
	public Playlist insert(Playlist playlist) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + playlist);
			PlaylistValidazione validazione = new PlaylistValidazione();

			if (validazione.playlistIsValid(playlist)) {
				PlaylistCRUD crud = new PlaylistCRUD();
				playlist = crud.insert(playlist);
				SqlMapFactory.instance().commitSession();
				return playlist;
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
	public Playlist update(Playlist playlist) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + playlist);
			PlaylistValidazione validazione = new PlaylistValidazione();

			if (validazione.playlistIsValid(playlist)) {
				PlaylistCRUD crud = new PlaylistCRUD();
				playlist = crud.update(playlist);
				SqlMapFactory.instance().commitSession();
				return playlist;
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
	public Playlist findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			PlaylistCRUD crud = new PlaylistCRUD();
			Playlist playlist = crud.findById(id);
			SqlMapFactory.instance().commitSession();
			return playlist;
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
			PlaylistCRUD crud = new PlaylistCRUD();
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
	public List<Playlist> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			PlaylistCRUD crud = new PlaylistCRUD();
			List<Playlist> listaPlaylist = crud.findAll();
			SqlMapFactory.instance().commitSession();
			return listaPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Playlist> findAllById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAllBy Id>>>" + id);
			PlaylistCRUD crud = new PlaylistCRUD();
			List<Playlist> listaPlaylist = crud.findAllById(id);
			SqlMapFactory.instance().commitSession();
			return listaPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public void deleteAll(List<Playlist> listaPlaylist) {

		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller delete>>>" + listaPlaylist);
			PlaylistCRUD crud = new PlaylistCRUD();
			crud.deleteAll(listaPlaylist);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();

		} finally {
			SqlMapFactory.instance().closeSession();
		}

	}
}
