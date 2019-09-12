package com.kiranico.misc;

public class ArmorQuery {
	private Integer num_lvl1_slots;
	private Integer num_lvl2_slots;
	private Integer num_lvl3_slots;
	private String skill1;
	private String skill2;
	
	public ArmorQuery(Integer n1, Integer n2, Integer n3, String s1, String s2) {
		num_lvl1_slots = n1;
		num_lvl2_slots = n2;
		num_lvl3_slots = n3;
		skill1 = s1;
		skill2 = s2;
	}

	public Integer getNum_lvl1_slots() {
		return num_lvl1_slots;
	}

	public void setNum_lvl1_slots(Integer num_lvl1_slots) {
		this.num_lvl1_slots = num_lvl1_slots;
	}

	public Integer getNum_lvl2_slots() {
		return num_lvl2_slots;
	}

	public void setNum_lvl2_slots(Integer num_lvl2_slots) {
		this.num_lvl2_slots = num_lvl2_slots;
	}

	public Integer getNum_lvl3_slots() {
		return num_lvl3_slots;
	}

	public void setNum_lvl3_slots(Integer num_lvl3_slots) {
		this.num_lvl3_slots = num_lvl3_slots;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
}
