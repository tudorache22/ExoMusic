package it.exolab.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.models.Abbonamento;

@Local
public interface AbbonamentoInterface {
	public Abbonamento insert(Abbonamento abbonamento);

	public Abbonamento update(Abbonamento abbonamento);

	public Abbonamento findById(Integer id);

	public void delete(Integer id);

	public List<Abbonamento> findAll();

}
