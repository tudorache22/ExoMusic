package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Utente;

@Local
public interface UtenteInterface {
	
	public Utente insert (Utente utente);

	public Utente update (Utente utente);
	
	public Utente findById (Integer id);
	
	public void delete (Integer id);
	
	public List<Utente> findAll();
	
	public Utente login (Utente utente);
}
