package it.exoBanca.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the ruolo database table.
 * 
 */
@Entity
@NamedQuery(name = "Ruolo.findAll", query = "SELECT r FROM Ruolo r")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ruolo")
	private Integer idRuolo;

	private String ruolo;

	// bi-directional many-to-one association to Utente
	@OneToMany(mappedBy = "ruolo")
	@JsonIgnore
	private List<Utente> utentes;

	public Ruolo() {
	}

	public Integer getIdRuolo() {
		return this.idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public List<Utente> getUtentes() {
		return this.utentes;
	}

	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	public Utente addUtente(Utente utente) {
		getUtentes().add(utente);
		utente.setRuolo(this);

		return utente;
	}

	public Utente removeUtente(Utente utente) {
		getUtentes().remove(utente);
		utente.setRuolo(null);

		return utente;
	}

}