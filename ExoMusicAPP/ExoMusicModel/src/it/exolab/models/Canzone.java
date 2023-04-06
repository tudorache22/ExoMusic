package it.exolab.models;

import java.util.List;

public class Canzone {
	private Integer idCanzone;
	private String titoloCanzone;
	private String durata;
	private Album album;
	private List<Playlist> listaPlaylist;
	public Integer getIdCanzone() {
		return idCanzone;
	}
	public void setIdCanzone(Integer idCanzone) {
		this.idCanzone = idCanzone;
	}
	public String getTitoloCanzone() {
		return titoloCanzone;
	}
	public void setTitoloCanzone(String titoloCanzone) {
		this.titoloCanzone = titoloCanzone;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public List<Playlist> getListaPlaylist() {
		return listaPlaylist;
	}
	public void setListaPlaylist(List<Playlist> listaPlaylist) {
		this.listaPlaylist = listaPlaylist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((durata == null) ? 0 : durata.hashCode());
		result = prime * result + ((idCanzone == null) ? 0 : idCanzone.hashCode());
		result = prime * result + ((listaPlaylist == null) ? 0 : listaPlaylist.hashCode());
		result = prime * result + ((titoloCanzone == null) ? 0 : titoloCanzone.hashCode());
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
		Canzone other = (Canzone) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (durata == null) {
			if (other.durata != null)
				return false;
		} else if (!durata.equals(other.durata))
			return false;
		if (idCanzone == null) {
			if (other.idCanzone != null)
				return false;
		} else if (!idCanzone.equals(other.idCanzone))
			return false;
		if (listaPlaylist == null) {
			if (other.listaPlaylist != null)
				return false;
		} else if (!listaPlaylist.equals(other.listaPlaylist))
			return false;
		if (titoloCanzone == null) {
			if (other.titoloCanzone != null)
				return false;
		} else if (!titoloCanzone.equals(other.titoloCanzone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Canzone [idCanzone=" + idCanzone + ", titoloCanzone=" + titoloCanzone + ", durata=" + durata
				+ ", album=" + album + ", listaPlaylist=" + listaPlaylist + "]";
	}

}
