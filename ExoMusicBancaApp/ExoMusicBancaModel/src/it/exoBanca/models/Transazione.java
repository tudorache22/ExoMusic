package it.exoBanca.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the transazione database table.
 * 
 */
@Entity
@NamedQuery(name = "Transazione.findAll", query = "SELECT t FROM Transazione t")
public class Transazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_transazione")
	private Integer idTransazione;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Float importo;

	private String stato;

	@Column(name = "tipo_transazione")
	private String tipoTransazione;

	// bi-directional many-to-one association to Otp
	@OneToMany(mappedBy = "transazione")
	private List<Otp> otps;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "id_utente")
	@JsonIgnore
	private Utente utente;

	public Transazione() {
	}

	public Integer getIdTransazione() {
		return this.idTransazione;
	}

	public void setIdTransazione(Integer idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getImporto() {
		return this.importo;
	}

	public void setImporto(Float importo) {
		this.importo = importo;
	}

	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTipoTransazione() {
		return this.tipoTransazione;
	}

	public void setTipoTransazione(String tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	public List<Otp> getOtps() {
		return this.otps;
	}

	public void setOtps(List<Otp> otps) {
		this.otps = otps;
	}

	public Otp addOtp(Otp otp) {
		getOtps().add(otp);
		otp.setTransazione(this);

		return otp;
	}

	public Otp removeOtp(Otp otp) {
		getOtps().remove(otp);
		otp.setTransazione(null);

		return otp;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}