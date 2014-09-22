package com.example.j2eeapp.utils.convertors;



import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.example.j2eeapp.dao.TournamentTypeDao;
import com.example.j2eeapp.domain.TTournamentTypeEntity;
import com.example.j2eeapp.utils.CommonUtils;

@FacesConverter("TTournamnetTypeConvertor")
public class TTournamentTypeConvertor extends GeneralEntityConvertor implements Converter{
	
	    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	TTournamentTypeEntity result = null;
    	TournamentTypeDao tournamentTypeDao = (TournamentTypeDao)CommonUtils.getBean("tournamentTypeDao",context);
    	if(tournamentTypeDao != null) {
    		result = tournamentTypeDao.findById(Long.valueOf(value));
    		/*List<TTournamentTypeEntity> types = tournamentTypeDao.findAll();
    		for (TTournamentTypeEntity type : types) {
    			if (type.getDescription().equals(value)) {
    				result = type;
    				break;
    			}
    		}
    		if (result == null) {
    			result = value;
    		}*/
    	}
    	return result;
    }

   

}
