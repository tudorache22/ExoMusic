package it.exolab.webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.exolab.controller.AbbonamentoController;
import it.exolab.interfaces.AbbonamentoInterface;
import it.exolab.models.Abbonamento;

@ApplicationPath("/rest")
public class Prova extends Application {

	@EJB
	AbbonamentoInterface abbonamentoInterface;

	public List<Abbonamento> allAbbonamenti() {
		AbbonamentoController a = new AbbonamentoController();
		return (a.findAll());
	}

}
