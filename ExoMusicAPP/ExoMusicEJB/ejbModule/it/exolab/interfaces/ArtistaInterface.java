package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Artista;

@Local
public interface ArtistaInterface {

	public Artista insert(Artista artista);

	public Artista update(Artista artista);

	public Artista findById(Integer id);

	public void delete(Integer id);

	public List<Artista> findAll();

	public Artista findInserimento(Artista artista);

}
