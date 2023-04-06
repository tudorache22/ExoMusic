package it.exolab.validazioni;

import it.exolab.models.Canzone;
import it.exolab.models.CanzoniPlaylist;
import it.exolab.models.Playlist;

public class CanzonePlaylistValidazione {

	public boolean canzoneIsValid(CanzoniPlaylist canzone) {
		if (!isValidTitoloCanzone(canzone.getCanzone())) {
			return false;
		}
		if (!isValidDurata(canzone.getPlaylist())) {
			return false;
		}
		return true;
	}

	private boolean isValidDurata(Playlist playlist) {
		return null != playlist;
	}

	private boolean isValidTitoloCanzone(Canzone canzone) {
		return null != canzone;
	}

}
