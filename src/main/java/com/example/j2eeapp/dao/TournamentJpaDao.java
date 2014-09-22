package com.example.j2eeapp.dao;

import com.example.j2eeapp.common.dao.GenericJpaDao;

import com.example.j2eeapp.domain.TournamentEntity;

public class TournamentJpaDao extends GenericJpaDao<TournamentEntity, Long> implements TournamentDao {
	public TournamentJpaDao() {
		super(TournamentEntity.class);
	}

}
