package it.exoBanca.models;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="stato_transazione")
@NamedQuery(name = "StatoTransazion.findAll", query = "SELECT t FROM StatoTransazione t")
public class StatoTransazione implements Serializable{

	private static final long serialVersionUID = -6565449867563150888L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_stato")
	private Integer idStato;
	
	private String stato;
	
	@OneToMany(mappedBy = "statoTransazione")
	@JsonIgnore
	private List<Transazione> transaziones;

	public Integer getIdStato() {
		return idStato;
	}

	public void setIdStato(Integer idStato) {
		this.idStato = idStato;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public List<Transazione> getTransaziones() {
		return transaziones;
	}

	public void setTransaziones(List<Transazione> transaziones) {
		this.transaziones = transaziones;
	}

}
