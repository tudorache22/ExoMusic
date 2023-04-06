package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Playlist;

@Local
public interface PlaylistInterface {
	
	public Playlist insert (Playlist playlist);

	public Playlist update (Playlist playlist);
	
	public Playlist findById (Integer id);
	
	public void delete (Integer id);
	
	public List<Playlist> findAll();
	
	public List<Playlist> findAllById(Integer id);

	public void deleteAll (List<Playlist> listaPlaylist);
}
