package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exolab.interfaces.UtenteInterface;
import it.exolab.models.Utente;
import it.exolab.view.ManageView;

@Named
@SessionScoped
public class GestioneUtentiBean implements Serializable {

	private static final long serialVersionUID = -8790632380465009365L;

	private List<Utente> listaUtenti;

	private Utente utenteSelezionato;

	@EJB
	private UtenteInterface utenteInterface;

	@PostConstruct
	public void init() {
		getAllUtenti();
	}

	public void getAllUtenti() {
		listaUtenti = utenteInterface.findAll();
	}

	public void scegliUtente(Integer id) {
		utenteSelezionato = utenteInterface.findById(id);
	}

	public void saveUtente() {
		if (utenteSelezionato.getIdUtente() == null) {
			utenteInterface.insert(utenteSelezionato);
//			listaUtenti.add(utenteSelezionato);

			getAllUtenti();

			ManageView.addMessage("Utente Added");
		} else {
			utenteInterface.update(utenteSelezionato);

			getAllUtenti();
			ManageView.addMessage("Utente Updated");
		}

	}

	public void deleteUtente() {
		System.out.println(utenteSelezionato);
		listaUtenti.remove(utenteSelezionato);
		utenteInterface.delete(utenteSelezionato.getIdUtente());
		utenteSelezionato = null;
		ManageView.addMessage("Utente Removed");
	}

	public void openNew() {
		utenteSelezionato = new Utente();
	}

	public List<Utente> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public Utente getUtenteSelezionato() {
		return utenteSelezionato;
	}

	public void setUtenteSelezionato(Utente utenteSelezionato) {
		this.utenteSelezionato = utenteSelezionato;
	}

}
