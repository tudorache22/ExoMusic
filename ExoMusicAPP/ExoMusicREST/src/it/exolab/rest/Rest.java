package it.exolab.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import it.exolab.models.Abbonamento;
import it.exolab.webService.Prova;
import it.exolab.webService.ServiceAbbonamento;

@Path("/ExomusicRest")
public class Rest {

	private ServiceAbbonamento service = new ServiceAbbonamento();

	private Prova serviceProva = new Prova();

	@POST
	@Path("/doAbbonamentoBase")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response doAbbonamentoBase(Abbonamento abbonamento) {

		System.out.println("DO ABBONAMENTO BAse REST<<<");

		try {
			abbonamento = service.doAbbonamentoBase(abbonamento);
			return Response.status(201).entity(abbonamento).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@POST
	@Path("/doAbbonamentoExtra")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response doAbbonamentoExtra(Abbonamento abbonamento) {

		System.out.println("DO ABBONAMENTO Extra REST<<<");

		try {
			abbonamento = service.doAbbonamentoExtra(abbonamento);
			return Response.status(201).entity(abbonamento).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@POST
	@Path("/doAbbonamentoPremium")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response doAbbonamentoPremium(Abbonamento abbonamento) {

		System.out.println("DO ABBONAMENTO Premium REST<<<");

		try {
			abbonamento = service.doAbbonamentoPremium(abbonamento);
			return Response.status(201).entity(abbonamento).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/allAbbonamenti")
	@Produces({ "application/json" })
	public Response getAllAbbonamenti() {

		System.out.println("DO ABBONAMENTO Premium REST<<<");

		try {
			List<Abbonamento> listaAbbonamenti = serviceProva.allAbbonamenti();
			return Response.status(201).entity(listaAbbonamenti).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
