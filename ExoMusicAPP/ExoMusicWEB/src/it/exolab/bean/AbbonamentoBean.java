package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exolab.interfaces.TipoAbbonamentoInterface;
import it.exolab.models.TipoAbbonamento;

@Named
@SessionScoped
public class AbbonamentoBean implements Serializable {

	private static final long serialVersionUID = -2414797046317356295L;

	private TipoAbbonamento abbonamentoSelezionato;

	private List<TipoAbbonamento> listaAbbonamenti;

	@EJB
	TipoAbbonamentoInterface tipoAbbonamentoInterface;

	@PostConstruct
	public void init() {
		abbonamentoSelezionato = new TipoAbbonamento();
		findAll();
	}

	public void findAll() {
		listaAbbonamenti = tipoAbbonamentoInterface.findAll();
	}

	public TipoAbbonamento getAbbonamentoSelezionato() {
		return abbonamentoSelezionato;
	}

	public void setAbbonamentoSelezionato(TipoAbbonamento abbonamentoSelezionato) {
		this.abbonamentoSelezionato = abbonamentoSelezionato;
	}

	public List<TipoAbbonamento> getListaAbbonamenti() {
		return listaAbbonamenti;
	}

	public void setListaAbbonamenti(List<TipoAbbonamento> listaAbbonamenti) {
		this.listaAbbonamenti = listaAbbonamenti;
	}

}
