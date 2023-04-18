package it.exolab.validazioni;

import it.exoBanca.models.Anagrafica;
import it.exoBanca.models.Utente;
import it.exolab.costanti.Const;

public class UtenteValidazione {

	public boolean utenteIsValid(Utente utente) {
		if (!isValidEmail(utente.getEmail())) {
			return false;
		}
		if (!isValidPassword(utente.getPassword())) {
			return false;
		}
		
		if(!isValidAnagrafica(utente.getAnagrafica())) {
			return false;
		}
		
		return true;
	}
	
	

	private boolean isValidEmail(String email) {
		System.out.println(email);
		return null !=  email && email.matches(Const.EMAIL_REGEX);
	}

	private boolean isValidPassword(String password) {
		return null !=  password  && password.matches(Const.PASSWORD_REGEX);
	}
	
	private boolean isValidAnagrafica(Anagrafica anagrafica) {
		return null != anagrafica;
	}
}
