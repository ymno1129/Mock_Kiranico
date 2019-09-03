package com.kiranico.entities;

import java.util.Map;

public class Skill {
	private String name;
	private Map<Integer, String> levels;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, String> getLevels() {
		return levels;
	}
	public void setLevels(Map<Integer, String> levels) {
		this.levels = levels;
	}
}
