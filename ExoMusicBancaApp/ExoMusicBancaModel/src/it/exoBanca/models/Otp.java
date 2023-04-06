package it.exoBanca.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the otp database table.
 * 
 */
@Entity
@NamedQuery(name = "Otp.findAll", query = "SELECT o FROM Otp o")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_otp")
	private Integer idOtp;

	private String codice;

	@Temporal(TemporalType.DATE)
	private Date creazione;

	@Temporal(TemporalType.DATE)
	private Date scadenza;

	// bi-directional many-to-one association to Transazione
	@ManyToOne
	@JoinColumn(name = "id_transazione")
	private Transazione transazione;

	private String stato;

	public Otp() {
	}

	public Integer getIdOtp() {
		return this.idOtp;
	}

	public void setIdOtp(Integer idOtp) {
		this.idOtp = idOtp;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Date getCreazione() {
		return this.creazione;
	}

	public void setCreazione(Date creazione) {
		this.creazione = creazione;
	}

	public Date getScadenza() {
		return this.scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public Transazione getTransazione() {
		return this.transazione;
	}

	public void setTransazione(Transazione transazione) {
		this.transazione = transazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

}