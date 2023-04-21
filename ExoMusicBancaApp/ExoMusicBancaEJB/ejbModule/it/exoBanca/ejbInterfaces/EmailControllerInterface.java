package it.exoBanca.ejbInterfaces;

import javax.ejb.Local;

import it.exoBanca.models.Email;

@Local
public interface EmailControllerInterface {
	
	boolean sendEmail(Email email);

}
