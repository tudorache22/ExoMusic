package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.AlbumMapper;
import it.exolab.models.Album;
import it.exolab.mybatis.SqlMapFactory;

public class AlbumCRUD extends BaseCrud<Album> {

	final static Logger logger = Logger.getLogger(AlbumCRUD.class);

	@Override
	public Album insert(Album model) {
		System.out.println("Sei nel albumCRUD insert>>>>" + model);
		try {
			AlbumMapper mapper = SqlMapFactory.instance().getMapper(AlbumMapper.class);
			mapper.insert(model);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Album update(Album model) {
		System.out.println("Sei nel Album crud update>>>" + model);

		try {
			AlbumMapper mapper = SqlMapFactory.instance().getMapper(AlbumMapper.class);
			mapper.update(model);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		System.out.println("Sei nel AlbumCrud>>>" + id);
		try {
			AlbumMapper mapper = SqlMapFactory.instance().getMapper(AlbumMapper.class);
			mapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Album findById(Integer id) {
		System.out.println("Sei nel Album crud FindById>>>" + id);

		try {
			AlbumMapper mapper = SqlMapFactory.instance().getMapper(AlbumMapper.class);
			Album album = mapper.findById(id);
			return album;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Album> findAll() {
		System.out.println("Sei nel Album crud FindAll");

		try {
			AlbumMapper mapper = SqlMapFactory.instance().getMapper(AlbumMapper.class);
			List<Album> listaAlbum = mapper.findAll();
			return listaAlbum;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Album findInserimento(Album album) {
		System.out.println("Sei nel Album crud findInserimento>>>" + album);

		try {
			AlbumMapper mapper = SqlMapFactory.instance().getMapper(AlbumMapper.class);
			Album album2 = mapper.findInserimento(album);
			return album2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
