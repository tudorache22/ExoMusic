package it.exolab.validazioni;

import it.exolab.models.Genere;

public class GenereValidazione {

	public boolean genereIsValid(Genere genere) {
		if (!isValidNomeGenere(genere.getNomeGenere())) {
			return false;
		}
		return true;
	}

	private boolean isValidNomeGenere(String nome) {
		return nome != null && nome.length() <= 20 && nome.length() >= 3;
	}

}
