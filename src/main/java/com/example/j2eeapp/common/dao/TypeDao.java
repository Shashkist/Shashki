package com.example.j2eeapp.common.dao;

import java.io.Serializable;

public interface TypeDao<T, ID extends Serializable> extends GenericDao<T, ID> {
	
	T findByDesc(String desc);

}
