package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.PlaylistMapper;
import it.exolab.models.Playlist;
import it.exolab.mybatis.SqlMapFactory;

public class PlaylistCRUD extends BaseCrud<Playlist> {

	final static Logger logger = Logger.getLogger(PlaylistCRUD.class);

	@Override
	public Playlist insert(Playlist model) {
		logger.info("Sei nel PlaylistCRUD insert>>>>" + model);
		try {

			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			mapper.insert(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Playlist update(Playlist model) {
		logger.info("Sei nel PlaylistCRUD update>>>>" + model);
		try {

			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel PlaylistCRUD delete>>>" + id);
		try {

			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Playlist findById(Integer id) {
		logger.info("Sei nel PlaylistCRUD FindById>>>>" + id);
		try {

			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			Playlist playlist = mapper.findById(id);

			return playlist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Playlist> findAll() {
		logger.info("Sei nel PlaylistCRUD FindAll");
		try {

			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			List<Playlist> ListaPlaylist = mapper.findAll();

			return ListaPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Playlist> findAllById(Integer id) {
		logger.info("Sei nel PlaylistCRUD FindAllbyid>>>>" + id);
		try {

			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			List<Playlist> listaPlaylist = mapper.findAllById(id);
			return listaPlaylist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void deleteAll(List<Playlist> listaPlaylist) {
		logger.info("Sei nel PlaylistCRUD delete>>>" + listaPlaylist);
		try {
			PlaylistMapper mapper = SqlMapFactory.instance().getMapper(PlaylistMapper.class);
			for (int i = 0; i < listaPlaylist.size(); i++) {
				mapper.delete(listaPlaylist.get(i).getIdPlaylist());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
