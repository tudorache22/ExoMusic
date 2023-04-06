package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.Ruolo;

@Local
public interface RuoloControllerInterface {

	Ruolo insert(Ruolo model);

	Ruolo update(Ruolo model);

	Ruolo findById(Integer idModel);

	List<Ruolo> findAll();

	void delete(Ruolo model);

}
