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
import it.exoBanca.ejbInterfaces.OtpControllerInterface;
import it.exoBanca.models.Otp;
import it.exoBanca.models.Transazione;

@Path("/OtpRest")
public class OtpRest extends BaseRest<Otp> {

	private OtpControllerInterface otpControllerInterface;

	final static Logger logger = Logger.getLogger(OtpRest.class);

	@POST
	@Path("/insertOtp")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Otp otp) {
		logger.info("sei nel OtpRest insert >>>" + otp);
		try {
			otp = new EJBFactory<OtpControllerInterface>(OtpControllerInterface.class).getEJB().insert(otp);
			return Response.status(201).entity(otp).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/updateOtp")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(Otp otp) {
		logger.info("sei nel OtpRest update >>>" + otp);
		try {
			otp = new EJBFactory<OtpControllerInterface>(OtpControllerInterface.class).getEJB().update(otp);
			return Response.status(201).entity(otp).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findOtpById/{idOtp}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idOtp") Integer idOtp) {
		logger.info("sei nel OtpRest findById >>>" + idOtp);
		try {
			Otp otp = new EJBFactory<OtpControllerInterface>(OtpControllerInterface.class).getEJB().findById(idOtp);
			return Response.status(201).entity(otp).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAllOtp")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel OtpRest findAll >>>");
		try {
			List<Otp> listaOtp = new EJBFactory<OtpControllerInterface>(OtpControllerInterface.class).getEJB()
					.findAll();
			return Response.status(201).entity(listaOtp).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/deleteOtp")
	@Produces({ "application/json" })
	public Response delete(Otp otp) {
		logger.info("sei nel OtpRest delete >>>" + otp);
		try {
			new EJBFactory<OtpControllerInterface>(OtpControllerInterface.class).getEJB().delete(otp);
			;
			return Response.status(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@POST
	@Path("/creaOtp")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response creaOtp(Transazione transazione) {
		logger.info("sei nel OtpRest Crea >>>");
		try {
			Otp otp = new EJBFactory<OtpControllerInterface>(OtpControllerInterface.class).getEJB()
					.nuovoOtp(transazione);
//			new EmailFactory().invioEmailStandard(utente, otp);
			System.out.println("email inviata");
			return Response.status(201).entity(otp.getCodice()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
