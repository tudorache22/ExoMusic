package it.exoBanca.models;

public class Email {
	
	private String subject;
	private String contenuto;
	private Utente utente;
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	@Override
	public String toString() {
		return "Email [subject=" + subject + ", contenuto=" + contenuto + ", utente=" + utente + "]";
	}
	
	

}
