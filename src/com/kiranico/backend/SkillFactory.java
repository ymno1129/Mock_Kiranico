package com.kiranico.backend;

import java.util.Map;

import com.kiranico.entities.Skill;

public class SkillFactory {
	private static SkillFactory sf;
	
	Map<String, Skill> all_skills;
	
	private SkillFactory() {
	}
	
	public static SkillFactory getInstance() {
		if (sf == null) sf = new SkillFactory();
		return sf;
	}
}
