package it.exolab.validazioni;

import java.util.Date;

import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;

public class ContoCorrenteValidazione {
	
	public boolean contoCorrenteIsValid(ContoCorrente contoCorrente) {
		if (!isValidNumeroConto(contoCorrente.getNumeroConto())) {
			return false;
		}
		if (!isValidUtente(contoCorrente.getUtente())) {
			return false;
		}
		if (!isValidDataScadenza(contoCorrente.getDataScadenza())) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidNumeroConto(String numeroConto) {
		return null != numeroConto && ""!= numeroConto;
	}
	
	public boolean isValidUtente(Utente utente) {
		return null != utente;
	}
	
	public boolean isValidDataScadenza(Date date) {
		return null != date;
	}

}
