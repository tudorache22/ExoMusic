package it.exolab.bean;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.exoBanca.models.StatoTransazione;
import it.exoBanca.models.Transazione;
import it.exoBanca.models.Utente;
import it.exolab.controllerService.AbbonamentoControllerService;

@Named
@SessionScoped
public class BancaBean implements Serializable {

	private static final long serialVersionUID = 6947856273789704065L;
	private Utente utente;
	private Boolean collegato;
	private String otpInserito;
	private Boolean transazioneFatta;
	private String otp;
	private Transazione transazione;
	
	@Inject
	private AbbonamentoBean abbonamentoBean;

	@PostConstruct
	public void init() {
		utente = new Utente();
		collegato = false;
		transazioneFatta = false;
		transazione= new Transazione();
	}

	public void faiLogin() {
		System.out.println(utente.getEmail());
		System.out.println(utente.getPassword());
		utente = new AbbonamentoControllerService().faiLogin(utente);
		if (null != utente) {
			collegato = true;
		}
		System.out.println("risposta bean " + collegato);
	}

	public void richiediOtp() {
//		String response = new AbbonamentoControllerService().richiediOtp(utente);
//		System.out.println("nel bean " + response);
//
//		otpRicevuto = (null != response && "" != response) ? true : false;

	}
	
	public void creaTransazione() {
		transazione.setUtente(utente);
		switch(abbonamentoBean.getAbbonamentoSelezionato().getIdTipoAbbonamento()) {
		case 2: transazione.setImporto(10f); break;
		case 3: transazione.setImporto(15f); break;
		case 4: transazione.setImporto(20f); break;
		}
		transazione.setTipoTransazione("abbonamento");
		StatoTransazione stato=new StatoTransazione();
		stato.setIdStato(6);
		stato.setStato("IN ATTESA");
		transazione.setStatoTransazione(stato);
		transazione.setData(new Date() );
		
		System.out.println(transazione);
		transazioneFatta= new AbbonamentoControllerService().faiTransazione(transazione);
		System.out.println(transazioneFatta);
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Boolean getCollegato() {
		return collegato;
	}

	public void setCollegato(Boolean collegato) {
		this.collegato = collegato;
	}

	public String getOtpInserito() {
		return otpInserito;
	}

	public void setOtpInserito(String otpInserito) {
		this.otpInserito = otpInserito;
	}

	public Boolean getTransazioneFatta() {
		return transazioneFatta;
	}

	public void setTransazioneFatta(Boolean otpRicevuto) {
		this.transazioneFatta = otpRicevuto;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
