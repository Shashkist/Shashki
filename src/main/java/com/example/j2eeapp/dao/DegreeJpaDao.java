package com.example.j2eeapp.dao;

import com.example.j2eeapp.common.dao.TypeJpaDao;
import com.example.j2eeapp.domain.TDegreeEntity;



	
public class DegreeJpaDao extends TypeJpaDao<TDegreeEntity, Long> implements DegreeDao {
	public DegreeJpaDao() {
		super(TDegreeEntity.class);
	}

	
}



