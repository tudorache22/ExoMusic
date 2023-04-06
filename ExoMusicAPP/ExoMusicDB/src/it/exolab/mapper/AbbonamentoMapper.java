package it.exolab.mapper;

import java.util.List;

import it.exolab.models.Abbonamento;

public interface AbbonamentoMapper {

	void insert(Abbonamento abbonamento);

	void update(Abbonamento abbonamento);

	void delete(Integer id);

	Abbonamento findById(Integer id);

	List<Abbonamento> findAll();

}
