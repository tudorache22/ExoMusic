package it.exoBanca.conf;

import javax.naming.InitialContext;

public class EJBFactory<T> {

	private final static String PREFIX = "java:global/ExoMusicBancaEAR-0.0.1-SNAPSHOT/ExoMusicBancaWEB/";

	private Class<T> interfaceClass;

	public EJBFactory(Class<T> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	@SuppressWarnings("unchecked")
	public T getEJB() throws Exception {
		InitialContext context = new InitialContext();
		System.out.println("simple name: " + interfaceClass.getSimpleName());
		System.out.println(" name: " + interfaceClass.getName());
		return (T) context.lookup(PREFIX + interfaceClass.getSimpleName() + "!" + interfaceClass.getName());
	}
}