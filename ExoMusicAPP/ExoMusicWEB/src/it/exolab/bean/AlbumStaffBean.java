package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.interfaces.AlbumInterface;
import it.exolab.models.Album;
import it.exolab.view.ManageView;

@Named
@SessionScoped
public class AlbumStaffBean implements Serializable {

	private static final long serialVersionUID = -4410133827653959866L;

	private List<Album> listaAlbum;

	private Album albumSelezionato;

	@EJB
	private AlbumInterface albumInterface;
	@Inject
	private ArtistaBean artistaBean;
	@Inject
	private GenereBean genereBean;

	@PostConstruct
	public void init() {
		System.out.println("sei dentro init album staffS");
		getAllAlbum();
		albumSelezionato = new Album();
	}

	public void saveAlbum() {
		if (null == albumSelezionato.getIdAlbum()) {
			albumSelezionato.setArtista(artistaBean.getArtistaSelezionato());
			albumSelezionato.setGenere(genereBean.getGenereSelezionato());
			albumSelezionato = albumInterface.insert(albumSelezionato);

//			Album albumInserito = albumInterface.findInserimento(albumSelezionato);
//			listaAlbum.add(albumInserito);

			getAllAlbum();

			if (null != albumSelezionato) {
				ManageView.addMessage("Album Aggiunto");
			} else {
				ManageView.addMessage("Album NON aggiunto");
			}
		} else {
			albumInterface.update(albumSelezionato);
			getAllAlbum();
			ManageView.addMessage("Album Aggiornato");
		}

	}

	public void deleteAlbum() {
//		listaAlbum.remove(albumSelezionato);
		albumInterface.delete(albumSelezionato.getIdAlbum());

		getAllAlbum();

		albumSelezionato = null;
		ManageView.addMessage("Album Cancellato");

	}

	public void selezionaAlbum(Album album) {
		System.out.println(album);
		albumSelezionato = albumInterface.findById(album.getIdAlbum());
		System.out.println("album selezionato " + albumSelezionato);
		ManageView.addMessage("Album Selezionato");
		System.out.println("hai selezionato " + albumSelezionato);
	}

	public void openNew() {
		albumSelezionato = new Album();
	}

	public void getAllAlbum() {
		listaAlbum = albumInterface.findAll();
	}

	public List<Album> getListaAlbum() {
		return listaAlbum;
	}

	public void setListaAlbum(List<Album> listaAlbum) {
		this.listaAlbum = listaAlbum;
	}

	public Album getAlbumSelezionato() {
		return albumSelezionato;
	}

	public void setAlbumSelezionato(Album albumSelezionato) {
		this.albumSelezionato = albumSelezionato;
	}

}
