package com.example.j2eeapp.dao;


import com.example.j2eeapp.common.dao.GenericJpaDao;
import com.example.j2eeapp.domain.PlayerEntity;

public class PlayerJpaDao extends GenericJpaDao<PlayerEntity, Long> implements PlayerDao {
	
	public PlayerJpaDao() {
		super(PlayerEntity.class);
	}
	
	

}
