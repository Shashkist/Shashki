package com.example.j2eeapp.utils;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

public class UIUtils implements Serializable{

	private static final long serialVersionUID = -7148964647479972393L;
	
	protected ResourceBundle getMessageBundle() {
		return ResourceBundle.getBundle("message-labels", new UTF8Control());
	}
	
	private int viewLoadCount = 0;
	
	public void greetOnViewLoad(ComponentSystemEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (viewLoadCount < 1 && !context.isPostback()) {
			String firstName = (String) event.getComponent().getAttributes().get("firstName");
			String lastName = (String) event.getComponent().getAttributes().get("lastName");
			
			FacesMessage message = new FacesMessage(String.format(getMessageBundle().getString("greetingMessage1"), firstName, lastName));
			context.addMessage("growlMessages", message);
			viewLoadCount ++;
		}
	}

}
