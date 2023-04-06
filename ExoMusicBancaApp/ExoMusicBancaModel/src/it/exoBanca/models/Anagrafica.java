package it.exoBanca.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the anagrafica database table.
 * 
 */
@Entity
@NamedQuery(name = "Anagrafica.findAll", query = "SELECT a FROM Anagrafica a")
public class Anagrafica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_anagrafica")
	private Integer idAnagrafica;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Column(name = "data_nascita")
	@JsonbDateFormat(value = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascita;

	@Column(name = "luogo_nascita")
	private String luogoNascita;

	private String nome;

	private String provincia;

	private String sesso;

	// bi-directional many-to-one association to Utente
	@OneToMany(mappedBy = "anagrafica")
	@JsonIgnore
	private List<Utente> utentes;

	public Anagrafica() {
	}

	public Integer getIdAnagrafica() {
		return this.idAnagrafica;
	}

	public void setIdAnagrafica(Integer idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSesso() {
		return this.sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public List<Utente> getUtentes() {
		return this.utentes;
	}

	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	public Utente addUtente(Utente utente) {
		getUtentes().add(utente);
		utente.setAnagrafica(this);

		return utente;
	}

	public Utente removeUtente(Utente utente) {
		getUtentes().remove(utente);
		utente.setAnagrafica(null);

		return utente;
	}

}