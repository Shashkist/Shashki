package com.example.j2eeapp.services;

import java.util.List;

import com.example.j2eeapp.common.dao.GenericDao;

public interface GeneralTypeService{ 

	/**
	 * Method returns all description from database in list
	 * @return list of all descriptions in database.
	 */
	List<String> getDescriptionList(GenericDao generalTypeDao);

}
