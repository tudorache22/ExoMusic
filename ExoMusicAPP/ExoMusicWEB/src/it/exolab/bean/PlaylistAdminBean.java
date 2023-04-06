package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exolab.interfaces.PlaylistInterface;
import it.exolab.models.Playlist;
import it.exolab.view.ManageView;

@Named
@SessionScoped
public class PlaylistAdminBean implements Serializable {

	private static final long serialVersionUID = 8463665945695535125L;

	private List<Playlist> listaPlaylist;
	private Playlist playlistSelezionata;

	@EJB
	private PlaylistInterface playlistInterface;

	@PostConstruct
	public void init() {
		System.out.println("sei nel init admin playlist");
		getAllPlaylist();

	}

	public void getAllPlaylist() {
		listaPlaylist = playlistInterface.findAll();
	}

	// DA AGGIUNGERE UTENTE
	public void savePlaylist() {
		if (playlistSelezionata.getIdPlaylist() == null) {
			playlistInterface.insert(playlistSelezionata);
//			listaPlaylist.add(playlistSelezionata);

			getAllPlaylist();

			ManageView.addMessage("Playlist Added");
		} else {
			playlistInterface.update(playlistSelezionata);
			getAllPlaylist();
			ManageView.addMessage("Playlist Updated");
		}

	}

	public void deletePlaylist() {
		listaPlaylist.remove(playlistSelezionata);
		playlistInterface.delete(playlistSelezionata.getIdPlaylist());
		playlistSelezionata = null;
		ManageView.addMessage("Playlist Removed");

	}

	public void openNew() {
		playlistSelezionata = new Playlist();
	}

	public List<Playlist> getListaPlaylist() {
		return listaPlaylist;
	}

	public void setListaPlaylist(List<Playlist> listaPlaylist) {
		this.listaPlaylist = listaPlaylist;
	}

	public Playlist getPlaylistSelezionata() {
		return playlistSelezionata;
	}

	public void setPlaylistSelezionata(Playlist playlistSelezionata) {
		this.playlistSelezionata = playlistSelezionata;
	}

}
