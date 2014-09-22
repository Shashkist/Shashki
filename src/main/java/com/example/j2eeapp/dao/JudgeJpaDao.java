package com.example.j2eeapp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.common.dao.GenericJpaDao;
import com.example.j2eeapp.domain.JudgeEntity;


public class JudgeJpaDao extends GenericJpaDao<JudgeEntity, Long> implements JudgeDao {
	public JudgeJpaDao() {
		super(JudgeEntity.class);
	}
	
	/**
	 * Queries database for judgeName availability
	 * 
	 * @param judgeName
	 * @return true if available
	 */
	public boolean checkAvailable(String judgeName) {
		Assert.notNull(judgeName);
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " u where u.judgeName = :judgeName").setParameter("judgeName", judgeName);
		
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}

	/**
	 * Queries judge by judgeName
	 * 
	 * @param judgeName
	 * @return judge entity
	 */
	public JudgeEntity loadJudgeByJudgeName(String judgeName) {
		Assert.notNull(judgeName);
		
		JudgeEntity judge = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.name = :judgeName").setParameter("judgeName", judgeName);
		
		try {
			judge = (JudgeEntity) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return judge;
	}


}
