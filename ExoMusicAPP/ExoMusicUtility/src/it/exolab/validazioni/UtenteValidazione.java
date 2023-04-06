package it.exolab.validazioni;

import it.exolab.models.Utente;

public class UtenteValidazione {

	private static final String NAME_REGEX = "^[a-zA-Z]+$";
	private static final String EMAIL_REGEX = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";
	private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	public boolean utenteIsValid(Utente utente) {
		if (!isValidName(utente.getNome())) {
			return false;
		}
		if (!isValidName(utente.getCognome())) {
			return false;
		}
		if (!isValidEmail(utente.getEmail())) {
			return false;
		}
		if (!isValidPassword(utente.getPassword())) {
			return false;
		}
		return true;
	}

	private boolean isValidName(String name) {
		return name != null && name.matches(NAME_REGEX) && (name.length() > 0 && name.length() <= 20);
	}

	private boolean isValidEmail(String email) {
		System.out.println(email);
		return email != null && email.matches(EMAIL_REGEX);
	}

	private boolean isValidPassword(String password) {
		return password != null && password.matches(PASSWORD_REGEX);
	}
}
