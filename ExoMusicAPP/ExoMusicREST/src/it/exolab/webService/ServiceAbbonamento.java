package it.exolab.webService;

import javax.ejb.EJB;

import it.exolab.interfaces.TipoAbbonamentoInterface;
import it.exolab.models.Abbonamento;

public class ServiceAbbonamento {

	@EJB
	TipoAbbonamentoInterface tipoAbbonamentoInterface;

	public Abbonamento doAbbonamentoBase(Abbonamento abbonamento) {
		if (abbonamento.getUtente().getSaldo() > 10) {
			abbonamento.setTipoAbbonamento(tipoAbbonamentoInterface.findById(2));
			abbonamento.setStato("attivo");
			abbonamento.setDataScadenza(" ");
			return abbonamento;
		} else {
			abbonamento.setStato("disattivo");
			return abbonamento;
		}
	}

	public Abbonamento doAbbonamentoExtra(Abbonamento abbonamento) {
		if (abbonamento.getUtente().getSaldo() > 20) {
			abbonamento.setTipoAbbonamento(tipoAbbonamentoInterface.findById(3));
			abbonamento.setStato("attivo");
			abbonamento.setDataScadenza(" ");
			return abbonamento;
		} else {
			abbonamento.setStato("disattivo");
			return abbonamento;
		}
	}

	public Abbonamento doAbbonamentoPremium(Abbonamento abbonamento) {
		if (abbonamento.getUtente().getSaldo() > 30) {
			abbonamento.setTipoAbbonamento(tipoAbbonamentoInterface.findById(4));
			abbonamento.setStato("attivo");
			abbonamento.setDataScadenza(" ");
			return abbonamento;
		} else {
			abbonamento.setStato("disattivo");
			return abbonamento;
		}
	}

}
