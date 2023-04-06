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

@Named("AlbumBean")
@SessionScoped
public class AlbumBean implements Serializable {

	private static final long serialVersionUID = 5984736244447160219L;

	private Album album;
	private List<Album> listaAlbum;
	private Album albumConsigliato;

	@EJB
	private AlbumInterface albumInterface;
	@Inject
	private MostraBean mostraBean;

	@PostConstruct
	public void init() {
		findAll();
		Album a = new Album();
		setAlbum(a);
		albumCasuale();
	}

	public void albumCasuale() {

		// (int)(Math.random() * range) + min
		int numeroCasuale = (int) (Math.random() * (listaAlbum.size() - 1) + 1);
		albumConsigliato = listaAlbum.get(numeroCasuale);
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Album> getListaAlbum() {
		return listaAlbum;
	}

	public void setListaAlbum(List<Album> listaAlbum) {
		this.listaAlbum = listaAlbum;
	}

	public void findAll() {
		List<Album> lista = albumInterface.findAll();
		setListaAlbum(lista);
		System.out.println(lista);
	}

	public void scegliAlbum(Integer id) {
		Album a = albumInterface.findById(id);
		setAlbum(a);
	}

	public void impostaAlbum(Album album) {
		setAlbum(album);
		mostraBean.cambiaPagina("singoloAlbum");
	}

	public Album getAlbumConsigliato() {
		return albumConsigliato;
	}

	public void setAlbumConsigliato(Album albumConsigliato) {
		this.albumConsigliato = albumConsigliato;
	}

}
