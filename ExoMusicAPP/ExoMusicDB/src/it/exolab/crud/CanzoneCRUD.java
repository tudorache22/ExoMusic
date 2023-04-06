package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.CanzoneMapper;
import it.exolab.models.Album;
import it.exolab.models.Canzone;
import it.exolab.mybatis.SqlMapFactory;

public class CanzoneCRUD extends BaseCrud<Canzone> {

	final static Logger logger = Logger.getLogger(CanzoneCRUD.class);

	@Override
	public Canzone insert(Canzone model) {
		logger.info("Sei nel canzoneCrud insert>>>>" + model);
		try {

			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			mapper.insert(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Canzone update(Canzone model) {
		logger.info("Sei nel canzoneCrud update>>>>" + model);
		try {

			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel canzoneCrud delete>>>>" + id);
		try {

			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Canzone findById(Integer id) {
		logger.info("Sei nel canzoneCrud findById>>>>" + id);
		try {

			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			Canzone canzone = mapper.findById(id);

			return canzone;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Canzone> findAll() {
		logger.info("Sei nel canzoneCrud findAll");
		try {

			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			List<Canzone> ListaCanzoni = mapper.findAll();

			return ListaCanzoni;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Canzone> findByAlbum(Album album) {
		logger.info("Sei nel canzoneCrud findByAlbum>>>" + album);
		try {
			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			List<Canzone> ListaCanzoni = mapper.findByAlbum(album);
			return ListaCanzoni;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Canzone findInserimento(Canzone canzone) {
		logger.info("Sei nel canzoneCrud findInserimento>>>>" + canzone);
		try {

			CanzoneMapper mapper = SqlMapFactory.instance().getMapper(CanzoneMapper.class);
			Canzone canzone2 = mapper.findInserimento(canzone);

			return canzone2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
