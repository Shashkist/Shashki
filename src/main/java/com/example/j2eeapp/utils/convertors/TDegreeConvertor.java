package com.example.j2eeapp.utils.convertors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.example.j2eeapp.common.domain.BasicEntity;
import com.example.j2eeapp.dao.DegreeDao;
import com.example.j2eeapp.domain.TDegreeEntity;
import com.example.j2eeapp.utils.CommonUtils;


@FacesConverter("TDegreeConvertor")
public class TDegreeConvertor extends GeneralEntityConvertor implements Converter{
	
	    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	TDegreeEntity result = null;
    	DegreeDao degreeDao = (DegreeDao)CommonUtils.getBean("degreeDao",context);
    	if(degreeDao != null) {
    		result = degreeDao.findById(Long.valueOf(value));
    	}
    	return result;
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

