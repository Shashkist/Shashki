package com.example.j2eeapp.utils.convertors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.example.j2eeapp.common.domain.BasicEntity;

public class GeneralEntityConvertor implements Converter {
	
	/**
	 * Never use this. (always override)
	 * @return always null
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	/**
	 * This method work for all classes which extends basicEntity
	 * Its extracts Id and returns it
	 */
	public String getAsString(FacesContext context, UIComponent component,Object object) {
		String result = null;
		if(object != null) {
			Long id = ((BasicEntity)object).getId();
			if (id != null) {
				result = id.toString();
			}
    	}
		return result;
	}
	
	
	
}
