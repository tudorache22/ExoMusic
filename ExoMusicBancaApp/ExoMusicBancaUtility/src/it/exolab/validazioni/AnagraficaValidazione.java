package it.exolab.validazioni;

import it.exoBanca.models.Anagrafica;
import it.exolab.costanti.Const;

public class AnagraficaValidazione {

	public boolean anagraficaIsValid(Anagrafica anagrafica) {
		if (!isValidNome(anagrafica.getNome())) {
			return false;
		}
		if(!isValidNome(anagrafica.getCognome())) {
			return false;
		}
		if(!isValidNome(anagrafica.getLuogoNascita())) {
			return false;
		}
		if(!isValidNome(anagrafica.getProvincia())) {
			return false;
		}
		if(!isValidProvincia(anagrafica.getProvincia())) {
			return false;
		}
		if(!isValidCodiceFiscale(anagrafica.getCodiceFiscale())) {
			return false;
		}
		
		
		return true;
	}
	
	
	private boolean isValidNome(String nome) {
		return null !=  nome && nome.matches(Const.NAME_REGEX);
	}
	
	private boolean isValidProvincia(String provincia) {
		return null !=  provincia && provincia.matches(Const.NAME_REGEX) && provincia.length()==2;
	}
	
	private boolean isValidCodiceFiscale(String codiceFiscale) {
		return null !=  codiceFiscale && codiceFiscale.matches(Const.CODICE_FISCALE_REGEX);
	}
	
	
	
}
