package com.example.j2eeapp.services;

import javax.faces.event.AjaxBehaviorEvent;

import com.example.j2eeapp.domain.UserEntity;

/**
 * Service providing user methods to work with data and entity.
 * @author ilia
 *
 */
public interface UserService {
	
	/**
	 * Create user - persist to database.
	 * @param Entity
	 * @return true if success
	 */
	boolean createUser(UserEntity Entity);

	/**
	 * Check username availability UI ajax use
	 * @param event
	 * @return
	 */
	boolean checkAvailable(AjaxBehaviorEvent event);
	
	/**
	 * Retrieves full user record from database by user name
	 * @param userName
	 * @return
	 */
	UserEntity loadUserEntityByUserName(String userName);
}
