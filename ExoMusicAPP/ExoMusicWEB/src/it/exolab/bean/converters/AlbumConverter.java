package it.exolab.bean.converters;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.bean.AlbumStaffBean;
import it.exolab.models.Album;

@FacesConverter(forClass = Album.class)
@Named
@RequestScoped
public class AlbumConverter implements Converter {

	@Inject
	private AlbumStaffBean albumBean;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Optional<Album> tempAlbum = albumBean.getListaAlbum().stream()
				.filter(album -> album.getTitoloAlbum().equals(arg2)).findFirst();
		return tempAlbum.isPresent() ? tempAlbum.get() : new Album();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Album) arg2).getTitoloAlbum();
	}

}
