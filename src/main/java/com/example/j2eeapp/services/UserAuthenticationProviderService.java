package com.example.j2eeapp.services;

import com.example.j2eeapp.domain.UserEntity;

/**
 * Service for user authentication
 * @author ilia
 *
 */
public interface UserAuthenticationProviderService {
	
	boolean processUserAuthentication(UserEntity userEntity);

}
