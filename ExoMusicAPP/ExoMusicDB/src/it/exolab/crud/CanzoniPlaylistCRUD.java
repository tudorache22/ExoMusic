package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import it.exolab.mapper.CanzoniPlaylistMapper;
import it.exolab.models.Canzone;
import it.exolab.models.CanzoniPlaylist;
import it.exolab.mybatis.SqlMapFactory;

public class CanzoniPlaylistCRUD extends BaseCrud<CanzoniPlaylist> {

	final static Logger logger = Logger.getLogger(CanzoniPlaylistCRUD.class);

	@Override
	public CanzoniPlaylist insert(CanzoniPlaylist model) {
		logger.info("Sei nel canzoniPlaylistCrud insert>>>>" + model);
		try {

			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			mapper.insert(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CanzoniPlaylist update(CanzoniPlaylist model) {
		logger.info("Sei nel canzoniPlaylistCrud update>>>>" + model);
		try {

			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel canzoniPlaylistCrud delete>>>>" + id);
		try {

			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CanzoniPlaylist findById(Integer id) {
		logger.info("Sei nel canzoniPlaylistCrud findById>>>>" + id);
		try {

			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			CanzoniPlaylist canzonePlaylist = mapper.findById(id);

			return canzonePlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<CanzoniPlaylist> findAll() {
		logger.info("Sei nel canzoniPlaylistCrud findAll");
		try {

			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			List<CanzoniPlaylist> ListaCanzoniPlaylist = mapper.findAll();

			return ListaCanzoniPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Canzone> findAllById(Integer id) {
		logger.info("Sei nel canzoniPlaylistCrud findAllById>>>>" + id);
		try {

			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			List<Canzone> listaCanzoniPlaylist = mapper.findAllById(id);

			return listaCanzoniPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteCanzone(CanzoniPlaylist canzonePlaylist) {
		logger.info("Sei nel canzoniPlaylistCrud delete>>>>" + canzonePlaylist);
		try {
			CanzoniPlaylistMapper mapper = SqlMapFactory.instance().getMapper(CanzoniPlaylistMapper.class);
			mapper.deleteCanzone(canzonePlaylist);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
