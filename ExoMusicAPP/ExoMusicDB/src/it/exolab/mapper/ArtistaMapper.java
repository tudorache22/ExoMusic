package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Artista;

public interface ArtistaMapper {
	void insert(Artista artista);

	void update(Artista artista);

	void delete(Integer id);

	Artista findById(Integer id);

	List<Artista> findAll();

	Artista findInserimento(Artista artista);

}
