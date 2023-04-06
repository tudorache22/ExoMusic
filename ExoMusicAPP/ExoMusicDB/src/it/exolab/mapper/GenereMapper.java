package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Genere;

public interface GenereMapper {

	void insert(Genere genere);

	void update(Genere genere);

	void delete(Integer id);

	Genere findById(Integer id);

	List<Genere> findAll();

	Genere findInserimento(Genere genere);

}
