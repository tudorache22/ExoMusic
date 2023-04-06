package it.exolab.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import it.exolab.interfaces.UtenteInterface;
import it.exolab.models.Utente;

@Named("UtenteBean")
@SessionScoped
public class UtenteBean implements Serializable {

	private static final long serialVersionUID = 7279445066084297426L;

	private Utente utente;

	final static Logger logger = Logger.getLogger(UtenteBean.class);

	@EJB
	private UtenteInterface utenteInterface;

	@Inject
	private MessagesView messagesView;
	@Inject
	private MostraBean mostraBean;

	public String login() {
		setUtente(utenteInterface.login(utente));
		logger.info(utente);
		if (utente != null) {
			logger.info(utente);
			switch (utente.getRuolo().getRuolo()) {
			case "utente":
				mostraBean.setPagina("home");
				return "utente.xhtml?faces-redirect=true";
			case "staff":
				mostraBean.setPagina("home");
				return "staff.xhtml?faces-redirect=true";
			case "admin":
				mostraBean.setPagina("home");
				return "admin.xhtml?faces-redirect=true";
			default:
				return null;
			}
		}

		else {
			messagesView.error();
			return null;
		}
	}

	public void register() {
		setUtente(utenteInterface.insert(utente));
		logger.info("utente nel bean:" + utente);
		mostraBean.cambiaPagina("login");
	}

	@PostConstruct
	public void init() {
		logger.info("inizio");
		utente = new Utente();

	}

	public String logout() {
		utente = new Utente();
		mostraBean.setPagina("login");
		return "index.xhtml?faces-redirect=true";

	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
