package com.example.j2eeapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.example.j2eeapp.common.domain.BasicEntity;


/**
 * Class holds judge entities like name etc..
 * @author ilia
 *
 */
@Entity
@Table (name = "JUDGE")
@Access(AccessType.FIELD)
public class JudgeEntity extends BasicEntity {
	
	private static final long serialVersionUID = 6650265326886084479L;
	
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="judge_id")
	private Set<TournamentEntity> tournaments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TournamentEntity> getTournaments() {
		if (tournaments == null) {
			tournaments = new HashSet<TournamentEntity>();
		}
		return tournaments;
	}


	public void setTournaments(Set<TournamentEntity> tournaments) {
		this.tournaments = tournaments;
	}
	
	

	
}
