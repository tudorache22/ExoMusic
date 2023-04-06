package it.exolab.validazioni;

import it.exolab.models.Album;
import it.exolab.models.Artista;
import it.exolab.models.Genere;

public class AlbumValidazione {

	public boolean albumIsValid(Album album) {
		if (!isValidTitoloCanzone(album.getTitoloAlbum())) {
			return false;
		}
		if (!isValidAnno(album.getAnno())) {
			return false;
		}
		if (!isValidCopertina(album.getCopertina())) {
			return false;
		}
		if (!isValidGenere(album.getGenere())) {
			return false;
		}
		if (!isValidArtista(album.getArtista())) {
			return false;
		}
		return true;
	}

	private boolean isValidArtista(Artista artista) {
		return null != artista;
	}

	private boolean isValidGenere(Genere genere) {
		return null != genere;
	}

	private boolean isValidCopertina(String copertina) {
		return null != copertina && copertina.length() <= 100 && copertina.length() >= 3;
	}

	private boolean isValidAnno(Integer anno) {
		return null != anno;
	}

	private boolean isValidTitoloCanzone(String nome) {
		return nome != null && nome.length() <= 20 && nome.length() >= 3;
	}

}
