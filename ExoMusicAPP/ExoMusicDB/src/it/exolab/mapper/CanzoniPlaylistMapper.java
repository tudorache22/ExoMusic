package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Canzone;
import it.exolab.models.CanzoniPlaylist;

public interface CanzoniPlaylistMapper {

	void insert(CanzoniPlaylist canzoniPlaylist);

	void update(CanzoniPlaylist canzoniPlaylist);

	void delete(Integer id);

	CanzoniPlaylist findById(Integer id);

	List<CanzoniPlaylist> findAll();

	List<Canzone> findAllById(Integer id);

	void deleteCanzone(CanzoniPlaylist canzoniPlaylist);
}
