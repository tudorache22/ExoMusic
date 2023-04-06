package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.TipoAbbonamento;

@Local
public interface TipoAbbonamentoInterface {
	public TipoAbbonamento findById(Integer id);

	List<TipoAbbonamento> findAll();
}
