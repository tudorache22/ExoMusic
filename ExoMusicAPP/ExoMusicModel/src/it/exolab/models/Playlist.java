package it.exolab.models;

import java.util.List;

public class Playlist {
	private Integer idPlaylist;
	private String nomePlaylist;
	private Utente utente;
	private List<Canzone> listaCanzoni;
	public Integer getIdPlaylist() {
		return idPlaylist;
	}
	public void setIdPlaylist(Integer idPlaylist) {
		this.idPlaylist = idPlaylist;
	}
	public String getNomePlaylist() {
		return nomePlaylist;
	}
	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
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
		result = prime * result + ((idPlaylist == null) ? 0 : idPlaylist.hashCode());
		result = prime * result + ((listaCanzoni == null) ? 0 : listaCanzoni.hashCode());
		result = prime * result + ((nomePlaylist == null) ? 0 : nomePlaylist.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
		Playlist other = (Playlist) obj;
		if (idPlaylist == null) {
			if (other.idPlaylist != null)
				return false;
		} else if (!idPlaylist.equals(other.idPlaylist))
			return false;
		if (listaCanzoni == null) {
			if (other.listaCanzoni != null)
				return false;
		} else if (!listaCanzoni.equals(other.listaCanzoni))
			return false;
		if (nomePlaylist == null) {
			if (other.nomePlaylist != null)
				return false;
		} else if (!nomePlaylist.equals(other.nomePlaylist))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Playlist [idPlaylist=" + idPlaylist + ", nomePlaylist=" + nomePlaylist + ", utente=" + utente
				+ ", listaCanzoni=" + listaCanzoni + "]";
	}

}
