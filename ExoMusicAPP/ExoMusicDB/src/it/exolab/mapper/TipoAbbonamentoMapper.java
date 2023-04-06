package it.exolab.mapper;

import java.util.List;

import it.exolab.models.TipoAbbonamento;

public interface TipoAbbonamentoMapper {
	TipoAbbonamento findById(Integer id);

	List<TipoAbbonamento> findAll();
}
