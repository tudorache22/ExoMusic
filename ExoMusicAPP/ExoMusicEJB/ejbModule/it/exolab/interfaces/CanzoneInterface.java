package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Album;
import it.exolab.models.Canzone;

@Local
public interface CanzoneInterface {

	public Canzone insert(Canzone canzone);

	public Canzone update(Canzone canzone);

	public Canzone findById(Integer id);

	public void delete(Integer id);

	public List<Canzone> findAll();

	public List<Canzone> findByAlbum(Album album);

	public Canzone findInserimento(Canzone canzone);

}
