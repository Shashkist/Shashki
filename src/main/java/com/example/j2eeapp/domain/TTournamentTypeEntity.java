package com.example.j2eeapp.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.j2eeapp.common.domain.TypeEntity;

/**
 * Class holds tournament types 
 * @author ilia
 *
 */
@Entity
@Table (name = "T_TOURNAMENT_TYPE")
@Access(AccessType.FIELD)
public class TTournamentTypeEntity extends TypeEntity {


	private static final long serialVersionUID = 6809700379944629163L;
	@Override
	public String toString() {
	    return super.toString();
	}
	
	
	

}
