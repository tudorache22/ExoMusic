package it.exolab.bean.converters;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.bean.ArtistaBean;
import it.exolab.models.Artista;

@FacesConverter(forClass = Artista.class)
@Named
@RequestScoped
public class ArtistaConverter implements Converter {

	@Inject
	private ArtistaBean artistaBean;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Optional<Artista> tempArtista = artistaBean.getListaArtisti().stream()
				.filter(artista -> artista.getNomeArtista().equals(arg2)).findFirst();
		return tempArtista.isPresent() ? tempArtista.get() : new Artista();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return ((Artista) arg2).getNomeArtista();
	}

}
