package it.exolab.validazioni;

import it.exolab.models.Album;
import it.exolab.models.Canzone;

public class CanzoneValidazione {

	public boolean canzoneIsValid(Canzone canzone) {
		if (!isValidTitoloCanzone(canzone.getTitoloCanzone())) {
			return false;
		}
		if (!isValidDurata(canzone.getDurata())) {
			return false;
		}
		if (!isValidAlbum(canzone.getAlbum())) {
			return false;
		}
		return true;
	}

	private boolean isValidTitoloCanzone(String nome) {
		return nome != null && nome.length() <= 20 && nome.length() >= 3;
	}

	private boolean isValidDurata(String durata) {
		return durata != null;
	}

	private boolean isValidAlbum(Album album) {
		return album != null;
	}

}
