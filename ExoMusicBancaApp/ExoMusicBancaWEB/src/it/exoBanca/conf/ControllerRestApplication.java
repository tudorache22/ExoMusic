package it.exoBanca.conf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import it.exoBanca.rest.AnagraficaRest;
import it.exoBanca.rest.ContoCorrenteRest;
import it.exoBanca.rest.OtpRest;
import it.exoBanca.rest.TransazioneRest;
import it.exoBanca.rest.UtenteRest;

@ApplicationPath("/rest")
public class ControllerRestApplication extends Application {

	private Set<Object> singletons;

	public ControllerRestApplication() {
		super();
		CorsFilter corsFilter = new CorsFilter();
		corsFilter.getAllowedOrigins().add("*");
		corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");

		singletons = new HashSet<Object>();
		singletons.add(corsFilter);

	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(UtenteRest.class);
		set.add(AnagraficaRest.class);
		set.add(ContoCorrenteRest.class);
		set.add(OtpRest.class);
		set.add(TransazioneRest.class);
		return set;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
