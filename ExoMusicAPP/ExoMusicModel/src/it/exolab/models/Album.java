package it.exolab.models;

import java.util.List;

public class Album {

	private Integer idAlbum;
	private String titoloAlbum;
	private String copertina;
	private Integer anno;
	private Artista artista;
	private Genere genere;
	private List<Canzone> listaCanzoni;

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getTitoloAlbum() {
		return titoloAlbum;
	}

	public void setTitoloAlbum(String titoloAlbum) {
		this.titoloAlbum = titoloAlbum;
	}

	public String getCopertina() {
		return copertina;
	}

	public void setCopertina(String copertina) {
		this.copertina = copertina;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public List<Canzone> getListaCanzoni() {
		return listaCanzoni;
	}

	public void setListaCanzoni(List<Canzone> listaCanzoni) {
		this.listaCanzoni = listaCanzoni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((copertina == null) ? 0 : copertina.hashCode());
		result = prime * result + ((genere == null) ? 0 : genere.hashCode());
		result = prime * result + ((idAlbum == null) ? 0 : idAlbum.hashCode());
		result = prime * result + ((listaCanzoni == null) ? 0 : listaCanzoni.hashCode());
		result = prime * result + ((titoloAlbum == null) ? 0 : titoloAlbum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (copertina == null) {
			if (other.copertina != null)
				return false;
		} else if (!copertina.equals(other.copertina))
			return false;
		if (genere == null) {
			if (other.genere != null)
				return false;
		} else if (!genere.equals(other.genere))
			return false;
		if (idAlbum == null) {
			if (other.idAlbum != null)
				return false;
		} else if (!idAlbum.equals(other.idAlbum))
			return false;
		if (listaCanzoni == null) {
			if (other.listaCanzoni != null)
				return false;
		} else if (!listaCanzoni.equals(other.listaCanzoni))
			return false;
		if (titoloAlbum == null) {
			if (other.titoloAlbum != null)
				return false;
		} else if (!titoloAlbum.equals(other.titoloAlbum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", titoloAlbum=" + titoloAlbum + ", copertina=" + copertina + ", anno="
				+ anno + ", artista=" + artista + ", genere=" + genere + ", listaCanzoni=" + listaCanzoni + "]";
	}


}
