package it.exolab.utility;

import java.sql.Date;
import java.time.LocalDate;

import it.exoBanca.models.Anagrafica;
import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;
import it.exolab.costanti.Const;

public class ContoCorrenteUtility {
	private final String voidString = "";

	public static ContoCorrente getContoCorrente(Utente utente) {
		return getContoCorrente(utente, 0f, Date.valueOf(LocalDate.now().plusYears(10)));
	}

	public static ContoCorrente getContoCorrente(Utente utente, Float saldo, Date data) {
		java.util.Date dataConvertita = new java.util.Date(data.getTime());
		ContoCorrente contoCorrente = new ContoCorrente();
		contoCorrente.setSaldo(saldo);
		contoCorrente.setDataScadenza(dataConvertita);
		contoCorrente.setNumeroConto(getNumeroConto(utente.getAnagrafica()));
		contoCorrente.setUtente(utente);
		contoCorrente.setStatoConto("disattivato");
		return contoCorrente;
	}

	public static String getNumeroConto(Anagrafica anagrafica) {
		return new ContoCorrenteUtility().generaNumeroContoByAnagrafica(anagrafica);
	}

	private String generaNumeroContoByAnagrafica(Anagrafica anagrafica) {
		int hashCodeId = Math.abs(anagrafica.getIdAnagrafica().hashCode());
		int hashCodeCognome = Math.abs(anagrafica.getCognome().hashCode());
		int hashCodeNascita = Math.abs(anagrafica.getLuogoNascita().hashCode());

		String stringaNumerica = getStringaNumericaConto(hashCodeId, hashCodeCognome, hashCodeNascita);
		String suffisso = getSuffissoConto(anagrafica.getDataNascita());
		return (isItalian() ? Const.PREFISSO_IT : Const.PREFISSO_EE) + stringaNumerica + suffisso;
	}

	private String getStringaNumericaConto(Integer... integers) {
		String number = voidString;
		String result = voidString;

		for (int n : integers) {
			number += n + voidString;
		}

		for (int i = 0; i < 15; i++) {
			result += number.charAt(i);
		}
		return result;
	}

	private String getSuffissoConto(java.util.Date data) {
		java.sql.Date sqlDate = new java.sql.Date(data.getTime());
		char random_1 = Const.CHARS_FOR_CONTO_CORRENTE_1.charAt((sqlDate).toLocalDate().getDayOfMonth());
		char random_2 = Const.CHARS_FOR_CONTO_CORRENTE_2.charAt((sqlDate).toLocalDate().getDayOfMonth());
		char random_3 = Const.CHARS_FOR_CONTO_CORRENTE_3.charAt((sqlDate).toLocalDate().getMonthValue());
		return random_1 + voidString + random_2 + voidString + random_3;
	}

	private boolean isItalian() {
		// implementare una logica di verifica per controllare se il luogo di nascita
		// corriponde ad un luogo italiano.
		return true;
	}
}
