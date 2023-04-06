package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.interfaces.CanzoneInterface;
import it.exolab.models.Canzone;
import it.exolab.view.ManageView;

@Named
@SessionScoped
public class CanzoniStaffBean implements Serializable {

	private static final long serialVersionUID = 4903185063608175462L;

	private List<Canzone> listaCanzoni;
	private Canzone canzoneSelezionata;

	@EJB
	private CanzoneInterface canzoneInterface;

	@Inject
	private AlbumStaffBean albumStaffBean;

	@PostConstruct
	public void init() {
		canzoneSelezionata = new Canzone();
		findAllCanzoni();
	}

	public void saveCanzone() {
		if (canzoneSelezionata.getIdCanzone() == null) {
			canzoneSelezionata.setAlbum(albumStaffBean.getAlbumSelezionato());
			canzoneInterface.insert(canzoneSelezionata);
//			Canzone canzoneInserita = canzoneInterface.findInserimento(canzoneSelezionata);
//			listaCanzoni.add(canzoneInserita);

			findAllCanzoni();

			ManageView.addMessage("Canzone Aggiunta");
		} else {
			canzoneInterface.update(canzoneSelezionata);
			findAllCanzoni();
			ManageView.addMessage("Canzone Aggiornata");
		}

	}

	public void deleteCanzone() {
		canzoneInterface.delete(canzoneSelezionata.getIdCanzone());
		listaCanzoni.remove(canzoneSelezionata);
		canzoneSelezionata = null;
		ManageView.addMessage("Canzone Rimossa");
	}

	public void openNew() {
		canzoneSelezionata = new Canzone();
	}

	public void findAllCanzoni() {
		listaCanzoni = canzoneInterface.findAll();
	}

	public List<Canzone> getListaCanzoni() {
		return listaCanzoni;
	}

	public void setListaCanzoni(List<Canzone> listaCanzoni) {
		this.listaCanzoni = listaCanzoni;
	}

	public Canzone getCanzoneSelezionata() {
		return canzoneSelezionata;
	}

	public void setCanzoneSelezionata(Canzone canzoneSelezionata) {
		this.canzoneSelezionata = canzoneSelezionata;
	}
}
