package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.ArtistaCRUD;
import it.exolab.interfaces.ArtistaInterface;
import it.exolab.models.Artista;
import it.exolab.mybatis.SqlMapFactory;
import it.exolab.validazioni.ArtistaValidazione;

@Stateless
@LocalBean
public class ArtistaController implements ArtistaInterface {

	final static Logger logger = Logger.getLogger(ArtistaController.class);

	@Override
	public Artista insert(Artista artista) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + artista);

			if (new ArtistaValidazione().artistaIsValid(artista)) {
				ArtistaCRUD crud = new ArtistaCRUD();
				artista = crud.insert(artista);
				SqlMapFactory.instance().commitSession();
				return artista;
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
	public Artista update(Artista artista) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + artista);

			if (new ArtistaValidazione().artistaIsValid(artista)) {
				ArtistaCRUD crud = new ArtistaCRUD();
				artista = crud.update(artista);
				SqlMapFactory.instance().commitSession();
				return artista;
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
	public Artista findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			Artista artista = new ArtistaCRUD().findById(id);
			SqlMapFactory.instance().commitSession();
			return artista;
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
			new ArtistaCRUD().delete(id);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Artista> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			ArtistaCRUD crud = new ArtistaCRUD();
			List<Artista> listaArtista = new ArtistaCRUD().findAll();
			SqlMapFactory.instance().commitSession();
			return listaArtista;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Artista findInserimento(Artista artista) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + artista);
			ArtistaCRUD crud = new ArtistaCRUD();
			Artista artista2 = crud.findInserimento(artista);
			SqlMapFactory.instance().commitSession();
			return artista2;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
