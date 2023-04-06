package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import it.exolab.createPdf.PdfCreator;
import it.exolab.interfaces.PlaylistInterface;
import it.exolab.models.Playlist;
import it.exolab.sendEmail.EmailFactory;
import it.exolab.view.ManageView;

@Named("playlistBean")
@SessionScoped
public class PlaylistBean implements Serializable {

	private static final long serialVersionUID = -3912464173179103277L;

	private List<Playlist> listaPlaylist;

	private Playlist selectedPlaylist;

	private boolean zeroPlaylist;

	@EJB
	private PlaylistInterface playlistInterface;

	@Inject
	private UtenteBean utenteBean;
	@Inject
	private MostraBean mostraBean;
	@Inject
	private CanzoniBean canzoniBean;

	@PostConstruct
	public void init() {
		selectedPlaylist = new Playlist();
		getPlaylistUtente();
	}

	public void openNew() {
		this.selectedPlaylist = new Playlist();
	}

	public void savePlaylist() {
		if (selectedPlaylist.getIdPlaylist() == null) {
			selectedPlaylist.setUtente(utenteBean.getUtente());
			playlistInterface.insert(selectedPlaylist);
//			listaPlaylist.add(selectedPlaylist);

			getPlaylistUtente();

			ManageView.addMessage("Playlist Aggiunta");
		} else {
			selectedPlaylist.setUtente(utenteBean.getUtente());
			playlistInterface.update(selectedPlaylist);
			getPlaylistUtente();
			ManageView.addMessage("Playlist Aggiornata");
		}

	}

	public void deletePlaylist() {
		listaPlaylist.remove(selectedPlaylist);
		playlistInterface.delete(selectedPlaylist.getIdPlaylist());
		this.selectedPlaylist = null;
		ManageView.addMessage("Product Removed");
	}

	public void controlloNumero() {
		if (listaPlaylist.size() > 0) {
			zeroPlaylist = false;
		} else {
			zeroPlaylist = true;
		}
		System.out.println(zeroPlaylist);
	}

	public void selezionaPlaylist(Playlist p) {
		System.out.println("Stai selezionando " + p);
		selectedPlaylist = p;
		canzoniBean.findCanzoniPlaylist();
		mostraBean.cambiaPagina("singolaPlaylist");
		PrimeFaces.current().ajax().update("formCanzoni:canzoni-playlist", ":contenuto");
	}

	public void nuovoPdf() {
		PdfCreator creaPdf = new PdfCreator();
		creaPdf.setUtente(utenteBean.getUtente());
		creaPdf.setListaPlaylist(listaPlaylist);
		creaPdf.creaPdf();
		System.out.println("creata nel bean");
	}

	public void riceviEmail() {
		EmailFactory emailFactory = new EmailFactory();
//		emailFactory.invioEmailStandard(utenteBean.getUtente());
		emailFactory.invioEmailFile(utenteBean.getUtente());
	}

	public void getPlaylistUtente() {
		listaPlaylist = playlistInterface.findAllById(utenteBean.getUtente().getIdUtente());
	}

	public List<Playlist> getListaPlaylist() {
		return listaPlaylist;
	}

	public void setListaPlaylist(List<Playlist> listaPlaylist) {
		this.listaPlaylist = listaPlaylist;
	}

	public Playlist getSelectedPlaylist() {
		return selectedPlaylist;
	}

	public void setSelectedPlaylist(Playlist selectedPlaylist) {
		this.selectedPlaylist = selectedPlaylist;
	}

	public boolean isZeroPlaylist() {
		return zeroPlaylist;
	}

	public void setZeroPlaylist(boolean zeroPlaylist) {
		this.zeroPlaylist = zeroPlaylist;
	}

}
