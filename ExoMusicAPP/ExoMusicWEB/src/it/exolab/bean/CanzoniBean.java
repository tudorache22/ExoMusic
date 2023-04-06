package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.interfaces.CanzoniPlaylistInterface;
import it.exolab.models.Canzone;
import it.exolab.models.CanzoniPlaylist;
import it.exolab.view.ManageView;

@Named("CanzoniBean")
@SessionScoped
public class CanzoniBean implements Serializable {

	private static final long serialVersionUID = 1565394525066420227L;

	private Canzone canzoneSelezionata;

	private List<Canzone> listaCanzoni;

	private CanzoniPlaylist canzonePlaylist;

	@EJB
	private CanzoniPlaylistInterface canzoniPlaylistInterface;

	@Inject
	private PlaylistBean playlistBean;

	@Inject
	private MostraBean mostraBean;

	@PostConstruct
	public void init() {
		canzonePlaylist = new CanzoniPlaylist();
		System.out.println("la playlist selezionata è:" + playlistBean.getSelectedPlaylist());
		findCanzoniPlaylist();
	}

	public void insertCanzone() {
		System.out.println(canzoneSelezionata);

		canzonePlaylist.setCanzone(canzoneSelezionata);
		canzonePlaylist.setPlaylist(playlistBean.getSelectedPlaylist());

		canzoniPlaylistInterface.insert(canzonePlaylist);

//		listaCanzoni.add(canzoneSelezionata);

		findCanzoniPlaylist();

		mostraBean.cambiaPagina("singolaPlaylist");
		ManageView.addMessage("Song Added To Playlist");

	}

	public void deleteCanzonePlaylist() {
		canzonePlaylist.setCanzone(canzoneSelezionata);
		canzonePlaylist.setPlaylist(playlistBean.getSelectedPlaylist());
		canzoniPlaylistInterface.delete(canzonePlaylist);
		ManageView.addMessage("Song removed from Playlist");
		listaCanzoni.remove(canzoneSelezionata);
	}

	public void findCanzoniPlaylist() {
		listaCanzoni = canzoniPlaylistInterface.findAllById(playlistBean.getSelectedPlaylist().getIdPlaylist());
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

	public CanzoniPlaylist getCanzonePlaylist() {
		return canzonePlaylist;
	}

	public void setCanzonePlaylist(CanzoniPlaylist canzonePlaylist) {
		this.canzonePlaylist = canzonePlaylist;
	}

}
