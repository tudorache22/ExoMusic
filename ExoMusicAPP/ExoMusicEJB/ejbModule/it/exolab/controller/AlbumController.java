package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.AlbumCRUD;
import it.exolab.interfaces.AlbumInterface;
import it.exolab.models.Album;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.AlbumValidazione;

@Stateless
@LocalBean
public class AlbumController implements AlbumInterface {

	final static Logger logger = Logger.getLogger(AlbumController.class);

	@Override
	public Album insert(Album album) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + album);

			if (new AlbumValidazione().albumIsValid(album)) {
				SqlMapFactory.instance().commitSession();
				album = new AlbumCRUD().insert(album);
				return album;
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
	public Album update(Album album) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + album);

			if (new AlbumValidazione().albumIsValid(album)) {
				album = new AlbumCRUD().update(album);
				SqlMapFactory.instance().commitSession();
				return album;
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
	public Album findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);

			Album album = new AlbumCRUD().findById(id);
			SqlMapFactory.instance().commitSession();
			return album;
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
			new AlbumCRUD().delete(id);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Album> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");

			List<Album> listaAlbum = new AlbumCRUD().findAll();
			SqlMapFactory.instance().commitSession();
			return listaAlbum;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Album findInserimento(Album album) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findInserimento>>>" + album);

			Album album2 = new AlbumCRUD().findInserimento(album);
			SqlMapFactory.instance().commitSession();
			return album2;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
