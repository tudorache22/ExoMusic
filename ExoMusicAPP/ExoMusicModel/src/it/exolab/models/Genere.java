package it.exolab.models;

public class Genere {
	private Integer idGenere;
	private String nomeGenere;
	public Integer getIdGenere() {
		return idGenere;
	}
	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}
	public String getNomeGenere() {
		return nomeGenere;
	}
	public void setNomeGenere(String nomeGenere) {
		this.nomeGenere = nomeGenere;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGenere == null) ? 0 : idGenere.hashCode());
		result = prime * result + ((nomeGenere == null) ? 0 : nomeGenere.hashCode());
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
		Genere other = (Genere) obj;
		if (idGenere == null) {
			if (other.idGenere != null)
				return false;
		} else if (!idGenere.equals(other.idGenere))
			return false;
		if (nomeGenere == null) {
			if (other.nomeGenere != null)
				return false;
		} else if (!nomeGenere.equals(other.nomeGenere))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Genere [idGenere=" + idGenere + ", nomeGenere=" + nomeGenere + "]";
	}

}
