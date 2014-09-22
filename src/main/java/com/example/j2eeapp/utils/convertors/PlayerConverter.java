package com.example.j2eeapp.utils.convertors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;




import com.example.j2eeapp.dao.PlayerDao;
import com.example.j2eeapp.domain.PlayerEntity;

import com.example.j2eeapp.utils.CommonUtils;

@FacesConverter("PlayerConverter")
public class PlayerConverter extends GeneralEntityConvertor implements Converter {
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	PlayerEntity result = null;
    	PlayerDao playerDao = (PlayerDao)CommonUtils.getBean("playerDao",context);
    	if(playerDao != null && value != null && !value.isEmpty()) {
    		result = playerDao.findById(Long.valueOf(value));
    	}
    	return result;
    }
	
	
}
