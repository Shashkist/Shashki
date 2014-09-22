package com.example.j2eeapp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import javax.persistence.Table;

import com.example.j2eeapp.common.domain.BasicEntity;

/**
 * Class holds tournament details like name etc..
 * @author ilia
 *
 */
@Entity
@Table (name = "tournament")
@Access(AccessType.FIELD)
public class TournamentEntity extends BasicEntity {

	private static final long serialVersionUID = -8741747184694267560L;
 
	@Column(name = "tournament_name")
	private String tournamentName;
	
	@Column(name = "tournament_date")
	private Date tournamentDate;
	
	@ManyToOne
	@JoinColumn(name="tournament_type")
	private TTournamentTypeEntity tournamentTypeEntity;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tournament_id")
	private List<PlayerTournamentEntity> playerTournaments;
	
	
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private JudgeEntity judge;*/
	
	
	//Getters and setters
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	/*public JudgeEntity getJudge() {
		return judge;
	}
	public void setJudge(JudgeEntity judge) {
		this.judge = judge;
	}
	
	*/
	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}
	public Date getTournamentDate() {
		return tournamentDate;
	}
	
	
	public TTournamentTypeEntity getTournamentTypeEntity() {
		return tournamentTypeEntity;
	}
	public void setTournamentTypeEntity(TTournamentTypeEntity tournamentTypeEntity) {
		this.tournamentTypeEntity = tournamentTypeEntity;
	}
	
	public List<PlayerTournamentEntity> getPlayerTournaments() {
		if (playerTournaments == null) {
			playerTournaments = new ArrayList<PlayerTournamentEntity>();
		}
		return playerTournaments;
	}
	public void setPlayerTournaments(List<PlayerTournamentEntity> playerTournaments) {
		this.playerTournaments = playerTournaments;
	}
	
	
	
	
}
