package com.example.j2eeapp.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.j2eeapp.common.domain.BasicEntity;

@Entity
@Table (name = "PLAYER_TOURNAMENT")
@Access(AccessType.FIELD)
public class PlayerTournamentEntity extends BasicEntity {

	private static final long serialVersionUID = 5739844529717549660L;
	
	
	
	@Column(name = "points")
	private Long points;
	
	@Column(name = "buhgolz")
	private Long buhgolz; 
	
	@Column(name = "shmuljan")
	private Long shmuljan;
	
	@Column(name = "sum_all_ratings")
	private Long opponentsRatings;
	
	@Column(name = "sum_small_points")
	private Long smallPoints;
	
	@Column(name = "is_finished")
	private boolean isFinished;
	
	@Column(name = "place")
	private Long place;
	
	@Column(name = "number_in_table")
	private Long numberInTable;
	
	@Column(name = "tour_number")
	private Long tourNumber;
	
	@ManyToOne
	@JoinColumn(name="player_id")
	private PlayerEntity playerEntity;

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public Long getBuhgolz() {
		return buhgolz;
	}

	public void setBuhgolz(Long buhgolz) {
		this.buhgolz = buhgolz;
	}

	public Long getShmuljan() {
		return shmuljan;
	}

	public void setShmuljan(Long shmuljan) {
		this.shmuljan = shmuljan;
	}

	public Long getOpponentsRatings() {
		return opponentsRatings;
	}

	public void setOpponentsRatings(Long opponentsRatings) {
		this.opponentsRatings = opponentsRatings;
	}

	public Long getSmallPoints() {
		return smallPoints;
	}

	public void setSmallPoints(Long smallPoints) {
		this.smallPoints = smallPoints;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Long getPlace() {
		return place;
	}

	public void setPlace(Long place) {
		this.place = place;
	}

	public Long getNumberInTable() {
		return numberInTable;
	}

	public void setNumberInTable(Long numberInTable) {
		this.numberInTable = numberInTable;
	}

	public void setTourNumber(Long tourNumber) {
		this.tourNumber = tourNumber;
	}

	public Long getTourNumber() {
		return tourNumber;
	}

	public PlayerEntity getPlayerEntity() {
		return playerEntity;
	}

	public void setPlayerEntity(PlayerEntity playerEntity) {
		this.playerEntity = playerEntity;
	}
	

	

}
