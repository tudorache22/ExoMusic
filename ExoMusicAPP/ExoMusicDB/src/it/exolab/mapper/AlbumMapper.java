package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Album;

public interface AlbumMapper {
	void insert(Album album);

	void update(Album album);

	void delete(Integer id);

	Album findById(Integer id);

	List<Album> findAll();

	Album findInserimento(Album album);

}
