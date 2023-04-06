package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.Utente;

@Local
public interface UtenteControllerInterface {
	Utente insert(Utente model);

	Utente update(Utente model);

	Utente findById(Integer idModel);

	List<Utente> findAll();

	void delete(Utente model);

	Utente findByEmailPassword(Utente utente);

}
