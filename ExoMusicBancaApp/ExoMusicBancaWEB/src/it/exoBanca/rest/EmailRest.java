package it.exoBanca.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import it.exoBanca.conf.EJBFactory;
import it.exoBanca.ejbInterfaces.EmailControllerInterface;
import it.exoBanca.models.Email;

@Path("/emailRest")
public class EmailRest {
	
	final static Logger logger = Logger.getLogger(EmailRest.class);
	
	@POST
	@Path("/sendEmail")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Email email) {
		logger.info("sei nel AnagraficaRest insert >>>" + email);
		try {
			boolean risposta = new EJBFactory<EmailControllerInterface>(EmailControllerInterface.class).getEJB().sendEmail(email);
			return Response.status(201).entity(risposta).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
