package com.example.j2eeapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.j2eeapp.common.dao.GenericDao;
import com.example.j2eeapp.common.domain.TypeEntity;

import com.example.j2eeapp.services.GeneralTypeService;


public class GeneralTypeServiceImpl implements GeneralTypeService {
		
	public List<String> getDescriptionList(GenericDao generalTypeDao) {
		ArrayList<TypeEntity> typeEntities = (ArrayList<TypeEntity>) generalTypeDao.findAll();
		ArrayList<String> descriptions = new ArrayList<String>(0);
		if (typeEntities != null) {
			for (TypeEntity typeEntity : typeEntities) {
				if (typeEntity.getDescription() != null) {
					descriptions.add(typeEntity.getDescription());
				}
			}
		}
		return descriptions;
	}
	
	

}
