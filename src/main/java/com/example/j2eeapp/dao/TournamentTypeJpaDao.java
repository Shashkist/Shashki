package com.example.j2eeapp.dao;




import com.example.j2eeapp.common.dao.TypeJpaDao;
import com.example.j2eeapp.domain.TTournamentTypeEntity;



public class TournamentTypeJpaDao extends TypeJpaDao<TTournamentTypeEntity, Long> implements TournamentTypeDao {
	public TournamentTypeJpaDao() {
		super(TTournamentTypeEntity.class);
	}

	
}
