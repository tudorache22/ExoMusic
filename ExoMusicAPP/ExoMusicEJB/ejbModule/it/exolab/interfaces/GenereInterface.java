package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Genere;

@Local
public interface GenereInterface {

	public Genere insert(Genere genere);

	public Genere update(Genere genere);

	public Genere findById(Integer id);

	public void delete(Integer id);

	public List<Genere> findAll();

	public Genere findInserimento(Genere genere);

}
