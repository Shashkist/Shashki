package com.example.j2eeapp.services;



import com.example.j2eeapp.domain.TournamentEntity;

public interface TournamentService {
	/**
	 * Create tournament - persist to database.
	 * @param Entity
	 * @return true if success
	 */
	boolean createTournament(TournamentEntity entity);
	
	/**
	 * Create tournament - persist to database.
	 * @param Entity, and user entity
	 * @return true if success
	 */
	//boolean createTournament(TournamentEntity entity, JudgeEntity judgeEntity);
}
