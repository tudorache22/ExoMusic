package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Playlist;


public interface PlaylistMapper {
	
    void insert(Playlist playlist);
	
	void update(Playlist playlist);
	
	void delete(Integer id);
	
	Playlist findById(Integer id);
	
	List<Playlist> findAll();
	
	List<Playlist> findAllById(Integer id);

}
