package it.exolab.models;

public class Artista {
	private Integer idArtista;
	private String nomeArtista;
	private Integer Ascoltatori;
	public Integer getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	public Integer getAscoltatori() {
		return Ascoltatori;
	}
	public void setAscoltatori(Integer ascoltatori) {
		Ascoltatori = ascoltatori;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ascoltatori == null) ? 0 : Ascoltatori.hashCode());
		result = prime * result + ((idArtista == null) ? 0 : idArtista.hashCode());
		result = prime * result + ((nomeArtista == null) ? 0 : nomeArtista.hashCode());
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
		Artista other = (Artista) obj;
		if (Ascoltatori == null) {
			if (other.Ascoltatori != null)
				return false;
		} else if (!Ascoltatori.equals(other.Ascoltatori))
			return false;
		if (idArtista == null) {
			if (other.idArtista != null)
				return false;
		} else if (!idArtista.equals(other.idArtista))
			return false;
		if (nomeArtista == null) {
			if (other.nomeArtista != null)
				return false;
		} else if (!nomeArtista.equals(other.nomeArtista))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Artista [idArtista=" + idArtista + ", nomeArtista=" + nomeArtista + ", Ascoltatori=" + Ascoltatori
				+ "]";
	}

}
