package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exolab.interfaces.GenereInterface;
import it.exolab.models.Genere;
import it.exolab.view.ManageView;

@Named
@SessionScoped
public class GenereBean implements Serializable {

	private static final long serialVersionUID = 8742057314167014852L;

	private List<Genere> listaGeneri;
	private Genere genereSelezionato;

	@EJB
	private GenereInterface genereInterface;

	@PostConstruct
	public void init() {
		getAllGeneri();
	}

	public void saveGenere() {
		if (genereSelezionato.getIdGenere() == null) {
			genereSelezionato = genereInterface.insert(genereSelezionato);

			getAllGeneri();

			if (null != genereSelezionato) {
				ManageView.addMessage("Genere Aggiunto");
			} else {
				ManageView.addMessage("Genere Non Aggiunto");
			}
		} else {
			genereSelezionato = genereInterface.update(genereSelezionato);
			getAllGeneri();
			if (null != genereSelezionato) {
				ManageView.addMessage("Genere Aggiornato");
			} else {
				ManageView.addMessage("Genere Non Aggiornato");
			}
		}

//		ManageView.manageGenere();
	}

	public void deleteGenere() {
		genereInterface.delete(genereSelezionato.getIdGenere());
		getAllGeneri();
		genereSelezionato = null;
	}

	public void openNew() {
		genereSelezionato = new Genere();
	}

	public void getAllGeneri() {
		listaGeneri = genereInterface.findAll();
	}

	public List<Genere> getListaGeneri() {
		return listaGeneri;
	}

	public void setListaGeneri(List<Genere> listaGeneri) {
		this.listaGeneri = listaGeneri;
	}

	public Genere getGenereSelezionato() {
		return genereSelezionato;
	}

	public void setGenereSelezionato(Genere genereSelezionato) {
		this.genereSelezionato = genereSelezionato;
	}

}
