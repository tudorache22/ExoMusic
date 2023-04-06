package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exolab.interfaces.ArtistaInterface;
import it.exolab.models.Artista;
import it.exolab.view.ManageView;

@Named
@SessionScoped
public class ArtistaBean implements Serializable {

	private static final long serialVersionUID = -2964555805296172792L;

	private List<Artista> listaArtisti;
	private Artista artistaSelezionato;

	@EJB
	private ArtistaInterface artistaInterface;

	@PostConstruct
	public void init() {
		getAllArtisti();
	}

	public void saveArtista() {
		if (artistaSelezionato.getIdArtista() == null) {
			artistaInterface.insert(artistaSelezionato);
//			Artista artistaInserito = artistaInterface.findInserimento(artistaSelezionato);
//			listaArtisti.add(artistaInserito);

			getAllArtisti();

			ManageView.addMessage("Artista Aggiunto");
		} else {
			artistaInterface.update(artistaSelezionato);
			getAllArtisti();
			ManageView.addMessage("Artista Aggiornato");
		}

	}

	public void deleteArtista() {
		listaArtisti.remove(artistaSelezionato);
		artistaInterface.delete(artistaSelezionato.getIdArtista());
		artistaSelezionato = null;
		ManageView.addMessage("Artista Rimosso");
	}

	public void openNew() {
		artistaSelezionato = new Artista();
	}

	public void getAllArtisti() {
		listaArtisti = artistaInterface.findAll();
	}

	public List<Artista> getListaArtisti() {
		return listaArtisti;
	}

	public void setListaArtisti(List<Artista> listaArtisti) {
		this.listaArtisti = listaArtisti;
	}

	public Artista getArtistaSelezionato() {
		return artistaSelezionato;
	}

	public void setArtistaSelezionato(Artista artistaSelezionato) {
		this.artistaSelezionato = artistaSelezionato;
	}

}
