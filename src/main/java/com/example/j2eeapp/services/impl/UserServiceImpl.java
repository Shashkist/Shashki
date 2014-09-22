package com.example.j2eeapp.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.services.UserService;
import com.example.j2eeapp.utils.UTF8Control;

/**
 * Service providing user methods to work with data and entity.
 * @author ilia
 *
 */
public class UserServiceImpl implements UserService, UserDetailsService{
	
	private UserDao userDao;
	
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	/**
	 * Create user - persist to database.
	 * @param Entity
	 * @return true if success
	 */
	public boolean createUser(UserEntity userEntity) {
		if (userDao.checkAvailable(userEntity.getUserName())) {
			try {
				userDao.save(userEntity);
			} catch(Exception e) {
				FacesMessage message = constructFatalMessage(e.getMessage(), null);
				getFacesContext().addMessage(null, message);
				
				return false;
			}
			return true;
		}
		FacesMessage message = constructErrorMessage(String.format(getMessageBundle().getString("userExistsMsg"), userEntity.getUserName()), null);
		getFacesContext().addMessage(null, message);
		return false;
	}



	/**
	 * Construct userDetails instance required by spring security
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userDao.loadUserByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No such user with name provided '%S'", userName));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		return userDetails;
	}
	
	protected FacesMessage constructErrorMessage(String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}
	
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	protected ResourceBundle getMessageBundle() {
		return ResourceBundle.getBundle("message-labels", new UTF8Control());
	}
	
	protected FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}
	
	protected FacesMessage constructInfoMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}


	/**
	 * Check userName availability UI ajax use
	 * @param event
	 * @return
	 */
	public boolean checkAvailable(AjaxBehaviorEvent event) {
		InputText inputText = (InputText) event.getSource();
		String value = (String) inputText.getValue();
		boolean isAvailable = userDao.checkAvailable(value);
		if(!isAvailable) {
			FacesMessage message = constructErrorMessage(String.format(getMessageBundle().getString("userExistsMsg"), value), null);
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		} else {
			FacesMessage message = constructInfoMessage(String.format(getMessageBundle().getString("userAvailableMsg"), value), null);
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		
		return isAvailable;
	}



	/**
	 * Retrieves full user record from database by user name
	 * @param userName
	 * @return
	 */
	public UserEntity loadUserEntityByUserName(String userName) {
		return userDao.loadUserByUserName(userName);
	}
	

}
