package com.example.j2eeapp.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.j2eeapp.common.domain.TypeEntity;

@Entity
@Table (name = "T_DEGREE")
@Access(AccessType.FIELD)
public class TDegreeEntity extends TypeEntity {

	private static final long serialVersionUID = -2428678872890181832L;
	
	@Column (name = "degree_tier")
	private Long degreeTier;

	public Long getDegreeTier() {
		return degreeTier;
	}

	public void setDegreeTier(Long degreeTier) {
		this.degreeTier = degreeTier;
	}
	
	

}
