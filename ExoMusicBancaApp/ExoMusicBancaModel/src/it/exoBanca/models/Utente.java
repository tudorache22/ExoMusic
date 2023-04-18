package it.exoBanca.models;

import java.io.Serializable;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_utente")
	private Integer idUtente;

	private String email;

	private String password;

	// bi-directional many-to-one association to ContoCorrente
	@OneToMany(mappedBy = "utente")
	@JsonbTransient
	@JsonManagedReference("contoCorrente")
	private List<ContoCorrente> contoCorrentes;

	// bi-directional many-to-one association to Transazione
	@OneToMany(mappedBy = "utente")
	@JsonbTransient
	@JsonManagedReference("transazione")
	private List<Transazione> transaziones;

	// bi-directional many-to-one association to Ruolo
	@ManyToOne
	@JoinColumn(name = "id_ruolo")
	private Ruolo ruolo;

	// bi-directional many-to-one association to Anagrafica
	@ManyToOne
	@JoinColumn(name = "id_anagrafica")
	private Anagrafica anagrafica;

	public Utente() {
	}

	public Integer getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ContoCorrente> getContoCorrentes() {
		return this.contoCorrentes;
	}

	public void setContoCorrentes(List<ContoCorrente> contoCorrentes) {
		this.contoCorrentes = contoCorrentes;
	}

	public ContoCorrente addContoCorrente(ContoCorrente contoCorrente) {
		getContoCorrentes().add(contoCorrente);
		contoCorrente.setUtente(this);

		return contoCorrente;
	}

	public ContoCorrente removeContoCorrente(ContoCorrente contoCorrente) {
		getContoCorrentes().remove(contoCorrente);
		contoCorrente.setUtente(null);

		return contoCorrente;
	}

	public List<Transazione> getTransaziones() {
		return this.transaziones;
	}

	public void setTransaziones(List<Transazione> transaziones) {
		this.transaziones = transaziones;
	}

	public Transazione addTransazione(Transazione transazione) {
		getTransaziones().add(transazione);
		transazione.setUtente(this);

		return transazione;
	}

	public Transazione removeTransazione(Transazione transazione) {
		getTransaziones().remove(transazione);
		transazione.setUtente(null);

		return transazione;
	}

	public Ruolo getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public Anagrafica getAnagrafica() {
		return this.anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}


}