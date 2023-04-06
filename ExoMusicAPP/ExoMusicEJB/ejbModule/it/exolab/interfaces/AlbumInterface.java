package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Album;

@Local
public interface AlbumInterface {

	public Album insert(Album album);

	public Album update(Album album);

	public Album findById(Integer id);

	public void delete(Integer id);

	public List<Album> findAll();

	public Album findInserimento(Album album);

}
