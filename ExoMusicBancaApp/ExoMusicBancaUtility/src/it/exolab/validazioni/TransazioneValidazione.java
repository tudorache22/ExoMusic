package it.exolab.validazioni;

import java.util.Date;

import it.exoBanca.models.StatoTransazione;
import it.exoBanca.models.Transazione;
import it.exoBanca.models.Utente;

public class TransazioneValidazione {
	

	public boolean transazioneIsValid(Transazione transazione) {
		if (!isValidTipoTransazione(transazione.getTipoTransazione())) {
			return false;
		}
		if (!isValidData(transazione.getData())) {
			return false;
		}
		if (!isValidStato(transazione.getStatoTransazione())) {
			return false;
		}
		if (!isValidUtente(transazione.getUtente())) {
			return false;
		}
		
		return true;
	}
	
	private boolean isValidTipoTransazione(String tipo) {
		return (tipo.equals("deposito" )|| tipo.equals("prelievo") || tipo.equals("abbonamento" )|| tipo.equals("bonificoEntrata") || tipo.equals("bonificoUscita" ));
	}
	
	private boolean isValidData(Date date) {
		return null != date;
	}
	
	private boolean isValidStato(StatoTransazione stato) {
		return null != stato;
	}
	
	private boolean isValidUtente(Utente utente) {
		return null != utente;
	}
	
}
