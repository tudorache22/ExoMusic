package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.StatoTransazione;

@Local
public interface StatoTransazioneInterface {
	
	StatoTransazione insert(StatoTransazione model);

	StatoTransazione update(StatoTransazione model);

	StatoTransazione findById(Integer idModel);

	List<StatoTransazione> findAll();

	void delete(StatoTransazione model);
}



