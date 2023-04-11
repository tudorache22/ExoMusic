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
import it.exoBanca.ejbInterfaces.ContoCorrenteControllerInterface;
import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;

@Path("/ContoCorrenteRest")
public class ContoCorrenteRest extends BaseRest<ContoCorrente> {

	private ContoCorrenteControllerInterface contoUtenteControllerInterface;

	final static Logger logger = Logger.getLogger(ContoCorrenteRest.class);

	@POST
	@Path("/insertContoCorrente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Utente utente) {
		logger.info("sei nel ContoCorrenteRest insert per persona:>>>" + utente);
		try {
			ContoCorrente contoUtente = new EJBFactory<ContoCorrenteControllerInterface>(
					ContoCorrenteControllerInterface.class).getEJB().insert(utente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/updateContoCorrente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(ContoCorrente contoUtente) {
		logger.info("sei nel ContoCorrenteRest update >>>" + contoUtente);
		try {
			contoUtente = new EJBFactory<ContoCorrenteControllerInterface>(ContoCorrenteControllerInterface.class)
					.getEJB().update(contoUtente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findContoCorrenteById/{idContoCorrente}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idContoCorrente") Integer idContoCorrente) {
		logger.info("sei nel ContoCorrenteRest findById >>>" + idContoCorrente);
		try {
			ContoCorrente contoUtente = new EJBFactory<ContoCorrenteControllerInterface>(
					ContoCorrenteControllerInterface.class).getEJB().findById(idContoCorrente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAllConti")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel ContoCorrenteRest findAll >>>");
		try {
			List<ContoCorrente> listaConti = new EJBFactory<ContoCorrenteControllerInterface>(
					ContoCorrenteControllerInterface.class).getEJB().findAll();
			return Response.status(201).entity(listaConti).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/deleteContoCorrente")
	@Produces({ "application/json" })
	public Response delete(ContoCorrente contoUtente) {
		logger.info("sei nel ContoCorrenteRest delete >>>" + contoUtente);
		try {
			new EJBFactory<ContoCorrenteControllerInterface>(ContoCorrenteControllerInterface.class).getEJB()
					.delete(contoUtente);
			;
			return Response.status(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findContoCorrenteByIdUtente/{idUtente}")
	@Produces({ "application/json" })
	public Response findByIdUtente(@PathParam("idUtente") Integer idUtente) {
		logger.info("sei nel ContoCorrenteRest findByIdUtente >>>" + idUtente);
		try {
			ContoCorrente contoUtente = new EJBFactory<ContoCorrenteControllerInterface>(
					ContoCorrenteControllerInterface.class).getEJB().findByIdUtente(idUtente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/findContoCorrenteByNumeroConto/{NumeroConto}")
	@Produces({ "application/json" })
	public Response findByNumeroConto(@PathParam("NumeroConto") String numeroConto) {
		logger.info("sei nel ContoCorrenteRest findContoCorrenteByNumeroConto >>>" + numeroConto);
		try {
			ContoCorrente contoUtente = new EJBFactory<ContoCorrenteControllerInterface>(
					ContoCorrenteControllerInterface.class).getEJB().findByNumeroConto(numeroConto);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	

	@Override
	Response insert(ContoCorrente model) {
		// TODO Auto-generated method stub
		return null;
	}

}
