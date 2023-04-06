package it.exolab.models;

public class Ruolo {
	private Integer idRuolo;
	private String ruolo;
	public Integer getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRuolo == null) ? 0 : idRuolo.hashCode());
		result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
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
		Ruolo other = (Ruolo) obj;
		if (idRuolo == null) {
			if (other.idRuolo != null)
				return false;
		} else if (!idRuolo.equals(other.idRuolo))
			return false;
		if (ruolo == null) {
			if (other.ruolo != null)
				return false;
		} else if (!ruolo.equals(other.ruolo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", ruolo=" + ruolo + "]";
	}

}
