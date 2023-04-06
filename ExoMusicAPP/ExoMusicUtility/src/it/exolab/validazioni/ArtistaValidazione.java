package it.exolab.validazioni;

import it.exolab.models.Artista;

public class ArtistaValidazione {

	public boolean artistaIsValid(Artista artista) {
		if (!isValidNomeArtistico(artista.getNomeArtista())) {
			return false;
		}
		if (!isValidAscoltatori(artista.getAscoltatori())) {
			return false;
		}
		return true;
	}

	private boolean isValidNomeArtistico(String nome) {
		return nome != null && nome.length() <= 20 && nome.length() >= 3;
	}

	private boolean isValidAscoltatori(Integer ascoltatori) {
		return ascoltatori != null;
	}

}
