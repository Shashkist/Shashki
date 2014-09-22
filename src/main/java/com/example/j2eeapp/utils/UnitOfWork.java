package com.example.j2eeapp.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javassist.expr.NewArray;

import com.example.j2eeapp.domain.TTournamentTypeEntity;
import com.example.j2eeapp.domain.TournamentEntity;
import com.example.j2eeapp.services.TournamentService;
import com.example.j2eeapp.services.TournamentTypeService;
import com.example.j2eeapp.services.impl.TournamentServiceImpl;
import com.example.j2eeapp.services.impl.TournamentTypeServiceImpl;

public class UnitOfWork implements Serializable{
	private static final long serialVersionUID = -5823753444320140256L;
	
	private HashMap<String, Object> attributes;
	private List<String> test = new ArrayList<String>(0);
	private List<TTournamentTypeEntity> tournamentType;
		
	
	
	public UnitOfWork() {
		this.attributes = new HashMap<String, Object>();
	}
	
   
    
    
	public List<String>  getTest() {
		test.add("dad");
		test.add("pukis");
		return test;
	}
	public void setTest(List<String>  test) {
		this.test = test;
	}
	
	
	

	public HashMap<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	public Object getAttribute(String attributeName) {
		return this.attributes.get(attributeName);
	}
	
	public void setAttribute(String attributeName, Object value) {
		this.attributes.put(attributeName, value);
	}




	public void setTournamentType(List<TTournamentTypeEntity> tournamentType) {
		this.tournamentType = tournamentType;
	}




	public List<TTournamentTypeEntity> getTournamentType() {
		return tournamentType;
	}




	
	
}
