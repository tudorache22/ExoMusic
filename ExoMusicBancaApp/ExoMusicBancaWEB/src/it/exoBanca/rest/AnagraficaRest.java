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
import it.exoBanca.ejbInterfaces.AnagraficaControllerInterface;
import it.exoBanca.models.Anagrafica;

@Path("/")
public class AnagraficaRest extends BaseRest<Anagrafica> {

	private AnagraficaControllerInterface anagraficaControllerInterface;

	final static Logger logger = Logger.getLogger(AnagraficaRest.class);

	@POST
	@Path("/insertAnagrafica")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Anagrafica anagrafica) {
		logger.info("sei nel AnagraficaRest insert >>>" + anagrafica);
		try {
			anagrafica = new EJBFactory<AnagraficaControllerInterface>(AnagraficaControllerInterface.class).getEJB()
					.insert(anagrafica);
			return Response.status(201).entity(anagrafica).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/updateAnagrafica")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(Anagrafica anagrafica) {
		logger.info("sei nel AnagraficaRest update >>>" + anagrafica);
		try {
			anagrafica = new EJBFactory<AnagraficaControllerInterface>(AnagraficaControllerInterface.class).getEJB()
					.update(anagrafica);
			return Response.status(201).entity(anagrafica).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAnagraficaById/{idAnagrafica}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idAnagrafica") Integer idAnagrafica) {
		logger.info("sei nel AnagraficaRest findById >>>" + idAnagrafica);
		try {
			Anagrafica anagrafica = new EJBFactory<AnagraficaControllerInterface>(AnagraficaControllerInterface.class)
					.getEJB().findById(idAnagrafica);
			return Response.status(201).entity(anagrafica).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAllAnagrafica")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel AnagraficaRest findAll >>>");
		try {
			List<Anagrafica> listaAnagrafica = new EJBFactory<AnagraficaControllerInterface>(
					AnagraficaControllerInterface.class).getEJB().findAll();
			return Response.status(201).entity(listaAnagrafica).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/deleteAnagrafica")
	@Produces({ "application/json" })
	public Response delete(Anagrafica anagrafica) {
		logger.info("sei nel AnagraficaRest delete >>>" + anagrafica);
		try {
			new EJBFactory<AnagraficaControllerInterface>(AnagraficaControllerInterface.class).getEJB()
					.delete(anagrafica);
			;
			return Response.status(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
}
