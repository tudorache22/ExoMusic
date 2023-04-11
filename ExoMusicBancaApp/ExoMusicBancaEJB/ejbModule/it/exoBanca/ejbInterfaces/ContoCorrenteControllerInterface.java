package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;

@Local
public interface ContoCorrenteControllerInterface {

	ContoCorrente insert(Utente model);

	ContoCorrente update(ContoCorrente model);

	ContoCorrente findById(Integer idModel);

	List<ContoCorrente> findAll();

	void delete(ContoCorrente model);

	ContoCorrente findByIdUtente(Integer id);
	
	ContoCorrente findByNumeroConto(String numeroConto);

}
