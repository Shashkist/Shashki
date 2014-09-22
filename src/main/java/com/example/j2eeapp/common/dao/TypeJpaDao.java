package com.example.j2eeapp.common.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;




public abstract class TypeJpaDao<T, ID extends Serializable> extends GenericJpaDao<T, ID> implements TypeDao<T, ID>{
	//constructor
	public TypeJpaDao(Class<T> persistentClass){
		super(persistentClass);
	}
	
	
	public T findByDesc(String desc) {
		T type = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.description = " + "'"+desc+"'");
		
		try {
			type =  (T) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return type;
	}
	
	
	
	
	

}
