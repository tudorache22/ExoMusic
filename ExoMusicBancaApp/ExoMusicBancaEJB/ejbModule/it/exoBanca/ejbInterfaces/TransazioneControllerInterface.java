package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Transazione;
import it.exoBanca.models.Utente;

@Local
public interface TransazioneControllerInterface {

	Transazione insert(Transazione model);

	Transazione update(Transazione model);

	Transazione findById(Integer idModel);

	List<Transazione> findAll();

	void delete(Transazione model);
	
	Transazione confermaTransazione(Transazione transazione);
}
