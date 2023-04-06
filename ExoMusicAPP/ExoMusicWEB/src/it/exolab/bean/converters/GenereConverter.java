package it.exolab.bean.converters;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.bean.GenereBean;
import it.exolab.models.Genere;

@FacesConverter(forClass = Genere.class)
@Named
@RequestScoped
public class GenereConverter implements Converter {

	@Inject
	GenereBean genereBean;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Optional<Genere> tempGenere = genereBean.getListaGeneri().stream()
				.filter(genere -> genere.getNomeGenere().equals(arg2)).findFirst();
		return tempGenere.isPresent() ? tempGenere.get() : new Genere();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return ((Genere) arg2).getNomeGenere();
	}

}
