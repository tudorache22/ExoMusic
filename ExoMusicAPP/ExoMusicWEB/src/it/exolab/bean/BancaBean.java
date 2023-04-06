package it.exolab.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exoBanca.models.Utente;
import it.exolab.controllerService.AbbonamentoControllerService;

@Named
@SessionScoped
public class BancaBean implements Serializable {

	private static final long serialVersionUID = 6947856273789704065L;
	private Utente utente;
	private Boolean collegato;
	private String otpInserito;
	private Boolean otpRicevuto;
	private String otp;

	@PostConstruct
	public void init() {
		utente = new Utente();
		collegato = false;
		otpRicevuto = false;
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
		String response = new AbbonamentoControllerService().richiediOtp(utente);
		System.out.println("nel bean " + response);

		otpRicevuto = (null != response && "" != response) ? true : false;

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

	public Boolean getOtpRicevuto() {
		return otpRicevuto;
	}

	public void setOtpRicevuto(Boolean otpRicevuto) {
		this.otpRicevuto = otpRicevuto;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
