package com.example.j2eeapp.services.impl;

import java.util.List;

import com.example.j2eeapp.dao.TournamentTypeDao;
import com.example.j2eeapp.services.TournamentTypeService;

public class TournamentTypeServiceImpl extends GeneralTypeServiceImpl implements TournamentTypeService{
	private TournamentTypeDao tournamentTypeDao;

	public TournamentTypeDao getTournamentTypeDao() {
		return tournamentTypeDao;
	}

	public void setTournamentTypeDao(TournamentTypeDao tournamentTypeDao) {
		this.tournamentTypeDao = tournamentTypeDao;
	}
	
	public List<String> getDescriptionList() {
		return getDescriptionList(tournamentTypeDao);
	}
	
	

}
