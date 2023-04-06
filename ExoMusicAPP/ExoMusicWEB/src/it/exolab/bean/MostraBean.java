package it.exolab.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named("MostraBean")
@SessionScoped
public class MostraBean implements Serializable {

	private static final long serialVersionUID = -2150730874355820273L;

	final static Logger logger = Logger.getLogger(MostraBean.class);

	private String pagina;

	@PostConstruct
	public void init() {
		pagina = "login";
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public void cambiaPagina(String ins) {
		setPagina(ins);
		logger.info(pagina);
	}
}
