package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Ruolo;

public interface RuoloMapper {
	
	
	  void insert(Ruolo ruolo);
		
		void update(Ruolo ruolo);
		
		void delete(Integer id);
		
		Ruolo findById(Integer id);
		
		List<Ruolo> findAll();

}
