package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Album;
import it.exolab.models.Canzone;

public interface CanzoneMapper {
	void insert(Canzone canzone);

	void update(Canzone canzone);

	void delete(Integer id);

	Canzone findById(Integer id);

	List<Canzone> findAll();

	List<Canzone> findByAlbum(Album album);

	Canzone findInserimento(Canzone canzone);

}
