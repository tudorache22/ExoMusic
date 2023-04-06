package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Canzone;
import it.exolab.models.CanzoniPlaylist;

@Local
public interface CanzoniPlaylistInterface {

	public CanzoniPlaylist insert(CanzoniPlaylist canzonePlaylist);

	public CanzoniPlaylist update(CanzoniPlaylist canzonePlaylist);

	public CanzoniPlaylist findById(Integer id);

	public void delete(CanzoniPlaylist canzonePlaylist);

	public List<CanzoniPlaylist> findAll();

	public List<Canzone> findAllById(Integer id);

}
