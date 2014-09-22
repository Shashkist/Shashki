package com.example.j2eeapp.domain;



import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;

import com.example.j2eeapp.common.domain.BasicEntity;

/**
 * Class holds user entities like name etc..
 * @author ilia
 *
 */
@Entity
@Table (name = "appuser")
public class UserEntity extends BasicEntity {
	private static final long serialVersionUID = 9014169812363387062L;
	
	
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		PasswordEncoder crypto = new PlaintextPasswordEncoder();
		this.password = crypto.encodePassword(password, null);
	}
	

}
