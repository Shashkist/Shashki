package com.example.j2eeapp.dao;

import com.example.j2eeapp.common.dao.GenericDao;
import com.example.j2eeapp.domain.JudgeEntity;


/**
 * Data access object interface to work with entity operations
 * @author ilia
 *
 */
public interface JudgeDao extends GenericDao<JudgeEntity, Long> {
	/**
	 * Queries database for judge name availability
	 * 
	 * @param judgeName
	 * @return true if available
	 */
	boolean checkAvailable(String judgeName);
	
	/**
	 * Queries judge by judgeName
	 * 
	 * @param judgeName
	 * @return User entity
	 */
	JudgeEntity loadJudgeByJudgeName(String judgeName);

}


