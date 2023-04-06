package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.Anagrafica;

@Local
public interface AnagraficaControllerInterface {

	Anagrafica insert(Anagrafica model);

	Anagrafica update(Anagrafica model);

	Anagrafica findById(Integer idModel);

	List<Anagrafica> findAll();

	void delete(Anagrafica model);
}
