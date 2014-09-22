package com.example.j2eeapp.services;

import com.example.j2eeapp.domain.JudgeEntity;
import com.example.j2eeapp.domain.TournamentEntity;
import com.example.j2eeapp.utils.UnitOfWork;


/**
 * Service providing judge methods to work with data and entity.
 * @author ilia
 *
 */
public interface JudgeService {
	
	/**
	 * Create judge - persist to database.
	 * @param Entity
	 * @return true if success
	 */
	boolean createJudge(JudgeEntity Entity);
	
	boolean createTournament(TournamentEntity tournamnetEntity, JudgeEntity judgeEntity);
	
	public void initLists(UnitOfWork unitOfWork,TournamentEntity tournamnetEntity );

}
