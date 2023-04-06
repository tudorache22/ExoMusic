package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Utente;

public interface UtenteMapper {
	
	void insert (Utente utente);
	
    void update(Utente utente);
	
	void delete(Integer id);
	
	Utente findById(Integer id);
	
	List<Utente> findAll();
	
	Utente login(Utente utente);
	
}
