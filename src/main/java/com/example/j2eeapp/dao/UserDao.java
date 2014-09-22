package com.example.j2eeapp.dao;

import com.example.j2eeapp.common.dao.GenericDao;
import com.example.j2eeapp.domain.UserEntity;

/**
 * Data access object interface to work with entity operations
 * @author ilia
 *
 */
public interface UserDao extends GenericDao<UserEntity, Long> {
	
	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String userName);
	
	/**
	 * Queries user by username
	 * 
	 * @param userName
	 * @return User entity
	 */
	UserEntity loadUserByUserName(String userName);

}
