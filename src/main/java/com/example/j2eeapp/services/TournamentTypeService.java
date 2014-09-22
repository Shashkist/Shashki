package com.example.j2eeapp.services;

import java.util.List;

import com.example.j2eeapp.dao.TournamentTypeDao;

public interface TournamentTypeService extends GeneralTypeService{
	public List<String> getDescriptionList();

	public TournamentTypeDao getTournamentTypeDao();
}
