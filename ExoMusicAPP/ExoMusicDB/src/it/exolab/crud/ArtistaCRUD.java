package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.ArtistaMapper;
import it.exolab.models.Artista;
import it.exolab.mybatis.SqlMapFactory;

public class ArtistaCRUD extends BaseCrud<Artista> {

	final static Logger logger = Logger.getLogger(ArtistaCRUD.class);

	@Override
	public Artista insert(Artista model) {
		logger.info("Sei nel artistaCRUD insert>>>>" + model);
		try {
			ArtistaMapper mapper = SqlMapFactory.instance().getMapper(ArtistaMapper.class);
			mapper.insert(model);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Artista update(Artista model) {
		logger.info("Sei nel artistaCRUD update>>>>" + model);
		try {

			ArtistaMapper mapper = SqlMapFactory.instance().getMapper(ArtistaMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel artistaCRUD delete>>>>" + id);
		try {

			ArtistaMapper mapper = SqlMapFactory.instance().getMapper(ArtistaMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Artista findById(Integer id) {
		logger.info("Sei nel artistaCRUD FindById>>>>" + id);
		try {

			ArtistaMapper mapper = SqlMapFactory.instance().getMapper(ArtistaMapper.class);
			Artista artista = mapper.findById(id);

			return artista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Artista> findAll() {
		logger.info("Sei nel artistaCRUD FindAll");
		try {
			ArtistaMapper mapper = SqlMapFactory.instance().getMapper(ArtistaMapper.class);
			List<Artista> ListaArtisti = mapper.findAll();
			return ListaArtisti;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Artista findInserimento(Artista artista) {
		logger.info("Sei nel artistaCRUD findInserimento>>>>" + artista);
		try {

			ArtistaMapper mapper = SqlMapFactory.instance().getMapper(ArtistaMapper.class);
			Artista artista2 = mapper.findInserimento(artista);

			return artista2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
