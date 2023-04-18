package it.exoBanca.models;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the conto_corrente database table.
 * 
 */
@Entity
@Table(name = "conto_corrente")
@NamedQuery(name = "ContoCorrente.findAll", query = "SELECT c FROM ContoCorrente c")
public class ContoCorrente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conto_corrente")
	private Integer idContoCorrente;

	@Column(name = "data_scadenza")
	@JsonbDateFormat(value = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataScadenza;

	@Column(name = "numero_conto")
	private String numeroConto;

	private Float saldo;
	
	@Column(name="stato_conto")
	private String statoConto;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "id_utente")
	@JsonBackReference("contoCorrente")
	private Utente utente;

	public ContoCorrente() {
	}

	public Integer getIdContoCorrente() {
		return this.idContoCorrente;
	}

	public void setIdContoCorrente(Integer idContoCorrente) {
		this.idContoCorrente = idContoCorrente;
	}

	public Date getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getNumeroConto() {
		return this.numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public Float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "ContoCorrente [idContoCorrente=" + idContoCorrente + ", dataScadenza=" + dataScadenza + ", numeroConto="
				+ numeroConto + ", saldo=" + saldo + ", utente=" + utente + "]";
	}

	public String getStatoConto() {
		return statoConto;
	}

	public void setStatoConto(String statoConto) {
		this.statoConto = statoConto;
	}

}