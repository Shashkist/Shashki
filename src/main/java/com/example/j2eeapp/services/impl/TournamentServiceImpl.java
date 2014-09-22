package com.example.j2eeapp.services.impl;

import com.example.j2eeapp.dao.TournamentDao;

import com.example.j2eeapp.domain.TournamentEntity;
import com.example.j2eeapp.services.TournamentService;


public class TournamentServiceImpl implements TournamentService{
	private TournamentDao tournamentDao;
	
	public void setTournamentDao(TournamentDao tournamentDao) {
		this.tournamentDao = tournamentDao;
	}

	public TournamentDao getTournamentDao() {
		return tournamentDao;
	}
	
	public boolean createTournament(TournamentEntity tournamnetEntity) {
		tournamentDao.save(tournamnetEntity);
		return true;
		
	}
	
	
	
	

}
