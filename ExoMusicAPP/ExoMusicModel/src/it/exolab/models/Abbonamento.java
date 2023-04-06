package it.exolab.models;

public class Abbonamento {

	private Integer idAbbonamento;
	private String stato;
	private String dataScadenza;
	private TipoAbbonamento tipoAbbonamento;
	private Utente utente;

	public Integer getIdAbbonamento() {
		return idAbbonamento;
	}

	public void setIdAbbonamento(Integer idAbbonamento) {
		this.idAbbonamento = idAbbonamento;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public TipoAbbonamento getTipoAbbonamento() {
		return tipoAbbonamento;
	}

	public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
		this.tipoAbbonamento = tipoAbbonamento;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataScadenza == null) ? 0 : dataScadenza.hashCode());
		result = prime * result + ((idAbbonamento == null) ? 0 : idAbbonamento.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((tipoAbbonamento == null) ? 0 : tipoAbbonamento.hashCode());
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
		Abbonamento other = (Abbonamento) obj;
		if (dataScadenza == null) {
			if (other.dataScadenza != null)
				return false;
		} else if (!dataScadenza.equals(other.dataScadenza))
			return false;
		if (idAbbonamento == null) {
			if (other.idAbbonamento != null)
				return false;
		} else if (!idAbbonamento.equals(other.idAbbonamento))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (tipoAbbonamento == null) {
			if (other.tipoAbbonamento != null)
				return false;
		} else if (!tipoAbbonamento.equals(other.tipoAbbonamento))
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
		return "Abbonamento [idAbbonamento=" + idAbbonamento + ", stato=" + stato + ", dataScadenza=" + dataScadenza
				+ ", tipoAbbonamento=" + tipoAbbonamento + ", utente=" + utente + "]";
	}

}
