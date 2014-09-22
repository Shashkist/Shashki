package com.example.j2eeapp.common.domain;

import javax.persistence.MappedSuperclass;


/**
 * Entity for types will be extended.
 * @author ilia
 *
 */
@MappedSuperclass
public class TypeEntity extends BasicEntity {

	private static final long serialVersionUID = -2722553554895554972L;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}

}
