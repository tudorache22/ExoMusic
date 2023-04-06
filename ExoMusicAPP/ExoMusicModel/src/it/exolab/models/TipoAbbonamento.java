package it.exolab.models;

public class TipoAbbonamento {

	private Integer idTipoAbbonamento;
	private String costo;
	private String nomeAbbonamento;
	private String privilegi;
	private String linkCopertina;

	public Integer getIdTipoAbbonamento() {
		return idTipoAbbonamento;
	}

	public void setIdTipoAbbonamento(Integer idTipoAbbonamento) {
		this.idTipoAbbonamento = idTipoAbbonamento;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getNomeAbbonamento() {
		return nomeAbbonamento;
	}

	public void setNomeAbbonamento(String nomeAbbonamento) {
		this.nomeAbbonamento = nomeAbbonamento;
	}

	public String getPrivilegi() {
		return privilegi;
	}

	public void setPrivilegi(String privilegi) {
		this.privilegi = privilegi;
	}

	public String getLinkCopertina() {
		return linkCopertina;
	}

	public void setLinkCopertina(String linkCopertina) {
		this.linkCopertina = linkCopertina;
	}

}
