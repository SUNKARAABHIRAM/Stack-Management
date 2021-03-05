package com.abhi.stack.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Instance {

	@Id
	private String Name;
	private String state;
	private String team;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "Instance [Name=" + Name + ", state=" + state + ", team=" + team + "]";
	}
	
	
}
