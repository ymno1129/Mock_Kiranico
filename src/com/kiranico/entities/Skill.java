package com.kiranico.entities;

import java.util.Map;

public class Skill {
	private String name;
	private Integer level;
	private String description;
	
	public Skill(String name, Integer lev, String desc) {
		this.name = name;
		this.level = lev;
		this.description = desc;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
