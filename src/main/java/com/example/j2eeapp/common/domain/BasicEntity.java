package com.example.j2eeapp.common.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base entity class which holds the basic entity to be extend
 * @author ilia
 *
 */
@MappedSuperclass
public class BasicEntity implements Serializable {
	private static final long serialVersionUID = 9014169812363387062L;
	private Long id;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	 public boolean equals(Object object) {
	        return (object.getClass().equals(this.getClass())) && (id != null) 
	             ? id.equals(((BasicEntity) object).getId()) 
	             : (object == this);
    }
	 
	public String toString() {
		if (id != null) {
			return this.id.toString();
		} else {
			return super.toString();
		}
	}

}
