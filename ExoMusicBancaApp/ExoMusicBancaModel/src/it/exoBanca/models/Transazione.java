package it.exoBanca.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonbDateFormat(value = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date data;

	private Float importo;

	@ManyToOne
	@JoinColumn(name="id_stato")
	private StatoTransazione statoTransazione;

	@Column(name = "tipo_transazione")
	private String tipoTransazione;

	// bi-directional many-to-one association to Otp
	@OneToMany(mappedBy = "transazione")
	@JsonIgnore
	private List<Otp> otps;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "id_utente")
	@JsonBackReference(value="transazione")
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

	public StatoTransazione getStatoTransazione() {
		return statoTransazione;
	}

	public void setStatoTransazione(StatoTransazione statoTransazione) {
		this.statoTransazione = statoTransazione;
	}

	@Override
	public String toString() {
		return "Transazione [idTransazione=" + idTransazione + ", data=" + data + ", importo=" + importo
				+ ", statoTransazione=" + statoTransazione + ", tipoTransazione=" + tipoTransazione + ", otps=" + otps
				+ ", utente=" + utente + "]";
	}

}