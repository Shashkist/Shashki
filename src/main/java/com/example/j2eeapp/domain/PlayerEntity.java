package com.example.j2eeapp.domain;


import java.util.Date;
import java.util.Set;

import javax.faces.event.AjaxBehaviorEvent;
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

import org.primefaces.component.autocomplete.AutoComplete;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

import com.example.j2eeapp.common.domain.BasicEntity;

@Entity
@Table (name = "PLAYER")
@Access(AccessType.FIELD)
public class PlayerEntity extends BasicEntity {

	private static final long serialVersionUID = 2072523979754718520L;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="player_id")
	private Set<PlayerTournamentEntity> playerTournaments;
	
	@Column(name = "player_name")
	private String playerName;
	
	@Column(name = "player_last_name")
	private String playerLastName;
	
	@Column(name = "player_rating")
	private Long playerRating;
	
	@ManyToOne
	@JoinColumn(name="player_degree")
	private TDegreeEntity playerDegree;
	
	@Column(name = "player_photo")
	private String playerPhoto;
	
	@Column(name = "birth_date")
	private Date birthDate;

	public Set<PlayerTournamentEntity> getPlayerTournaments() {
		return playerTournaments;
	}

	public void setPlayerTournaments(Set<PlayerTournamentEntity> playerTournaments) {
		this.playerTournaments = playerTournaments;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getPlayerRating() {
		return playerRating;
	}

	public void setPlayerRating(Long playerRating) {
		this.playerRating = playerRating;
	}

	public TDegreeEntity getPlayerDegree() {
		return playerDegree;
	}

	public void setPlayerDegree(TDegreeEntity playerDegree) {
		this.playerDegree = playerDegree;
	}

	public String getPlayerPhoto() {
		return playerPhoto;
	}

	public void setPlayerPhoto(String playerPhoto) {
		this.playerPhoto = playerPhoto;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPlayerLastName() {
		return playerLastName;
	}

	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}
	
	
	public void handleChange(SelectEvent event) {
		AutoComplete inputText = (AutoComplete) event.getSource();
		String value = (String) inputText.getValue();
		//String playerName = value.getPlayerName();
		// playerLastName = value.getPlayerLastName();
		
		String value2 = getPlayerName();
		playerLastName = value2;
		playerRating = 1800L;
	}
	
	
	
	
	 
	 
	

}
