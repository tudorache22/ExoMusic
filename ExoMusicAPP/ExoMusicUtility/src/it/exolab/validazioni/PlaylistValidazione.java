package it.exolab.validazioni;

import it.exolab.models.Playlist;
import it.exolab.models.Utente;

public class PlaylistValidazione {

	public boolean playlistIsValid(Playlist playlist) {
		if (!isValidNomePlaylist(playlist.getNomePlaylist())) {
			return false;
		}
		if (!isValidUtente(playlist.getUtente())) {
			return false;
		}
		return true;
	}

	private boolean isValidUtente(Utente utente) {
		return null != utente;
	}

	private boolean isValidNomePlaylist(String nomePlaylist) {
		return null != nomePlaylist && nomePlaylist.length() >= 3 && nomePlaylist.length() <= 20;
	}

}
