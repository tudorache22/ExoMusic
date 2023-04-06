package it.exolab.bean.converters;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.bean.PlaylistBean;
import it.exolab.models.Playlist;

@FacesConverter(forClass = Playlist.class)
@Named
@RequestScoped
public class PlaylistConverter implements Converter {

	@Inject
	PlaylistBean playlistBean;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Optional<Playlist> tempPlaylist = playlistBean.getListaPlaylist().stream()
				.filter(playlist -> playlist.getNomePlaylist().equals(arg2)).findFirst();
		return tempPlaylist.isPresent() ? tempPlaylist.get() : new Playlist();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Playlist) arg2).getNomePlaylist();
	}

}
