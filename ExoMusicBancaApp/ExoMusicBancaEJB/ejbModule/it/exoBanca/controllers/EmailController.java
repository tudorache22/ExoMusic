package it.exoBanca.controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.EmailControllerInterface;
import it.exoBanca.models.Email;
import it.exolab.sendEmail.EmailFactory;

@Stateless(name="EmailControllerInterface")
@LocalBean
public class EmailController implements EmailControllerInterface{

	@Override
	public boolean sendEmail(Email email) {
		return new EmailFactory().invioEmail(email);
	}

}
