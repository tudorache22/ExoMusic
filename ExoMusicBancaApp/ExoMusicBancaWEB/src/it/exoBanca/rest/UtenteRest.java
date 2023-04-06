package it.exoBanca.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import it.exoBanca.conf.EJBFactory;
import it.exoBanca.ejbInterfaces.UtenteControllerInterface;
import it.exoBanca.models.Utente;

@Path("/UtenteRest")
public class UtenteRest extends BaseRest<Utente> {

	private UtenteControllerInterface utenteControllerInterface;

	final static Logger logger = Logger.getLogger(UtenteRest.class);

	@POST
	@Path("/insertUtente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Utente utente) {
		logger.info("sei nel UtenteRest insert >>>" + utente);
		try {
			utente = new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB().insert(utente);
//			System.out.println("data : " + utente.getAnagrafica().getDataNascita());
			return Response.status(201).entity(utente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/updateUtente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(Utente utente) {
		logger.info("sei nel UtenteRest update >>>" + utente);
		try {
			utente = new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB().update(utente);
			return Response.status(201).entity(utente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findUtenteById/{idUtente}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idUtente") Integer idUtente) {
		logger.info("sei nel UtenteRest findById >>>" + idUtente);
		try {
			Utente utente = new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB()
					.findById(idUtente);
			return Response.status(201).entity(utente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAllUtenti")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel UtenteRest findAll >>>");
		try {
			List<Utente> listaUtenti = new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class)
					.getEJB().findAll();
			return Response.status(201).entity(listaUtenti).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/deleteUtente")
	@Produces({ "application/json" })
	public Response delete(Utente utente) {
		logger.info("sei nel UtenteRest delete >>>" + utente);
		try {
			new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB().delete(utente);
			;
			return Response.status(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@POST
	@Path("/faiLogin")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response login(Utente utente) {
		logger.info("sei nel UtenteRest fai login >>>" + utente);
		try {
			utente = new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB()
					.findByEmailPassword(utente);
			if (null != utente) {
				return Response.status(201).entity(utente).build();
			} else {
				return Response.status(400).entity(utente).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
