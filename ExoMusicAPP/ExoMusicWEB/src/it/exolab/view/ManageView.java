package it.exolab.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ManageView {

	public static void addMessage(String messaggio) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messaggio));
	}

}
