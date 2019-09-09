package com.kiranico.entities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

public class Armorset {
	private String name;
	private Monster monster;
	private Armor head;
	private Armor chest;
	private Armor arm;
	private Armor waist;
	private Armor leg;
	private Skill bonus;
	
	private Integer defense;
	private Integer fire_res;
	private Integer water_res;
	private Integer thunder_res;
	private Integer ice_res;
	private Integer dragon_res;
	
	@Transient
	private String img_path;
	@Transient
	private Integer num_level1_slots;
	@Transient
	private Integer num_level2_slots;
	@Transient
	private Integer num_level3_slots;
	@Transient
	private String skill_desc;
	@Transient
	private Map<String, Integer> skill_map;
	
	public Map<String, Integer> getSkill_map(){
		if (skill_map != null) return skill_map;
		
		skill_map = new HashMap<String, Integer>();
		Armor[] parts = {head, chest, arm, waist, leg};
		for (Armor part: parts) {
			if (part == null) continue;
			if (part.getSkill1() != null) {
				String name = part.getSkill1().getName();
				Integer level = part.getSkill1().getLevel();
				if (skill_map.containsKey(name)) skill_map.put(name, skill_map.get(name) + level);
				else skill_map.put(name, level);
			}
			if (part.getSkill2() != null) {
				String name = part.getSkill2().getName();
				Integer level = part.getSkill2().getLevel();
				if (skill_map.containsKey(name)) skill_map.put(name, skill_map.get(name) + level);
				else skill_map.put(name, level);
			}
		}
		return skill_map;
	}
	
	public Integer getNum_level1_slots() {
		int num = 0;
		if (head != null) num += head.getNum_level1_slots();
		if (chest != null) num += chest.getNum_level1_slots();
		if (arm != null) num += arm.getNum_level1_slots();
		if (waist != null) num += waist.getNum_level1_slots();
		if (leg != null) num += leg.getNum_level1_slots();
		return num;
	}

	public Integer getNum_level2_slots() {
		int num = 0;
		if (head != null) num += head.getNum_level2_slots();
		if (chest != null) num += chest.getNum_level2_slots();
		if (arm != null) num += arm.getNum_level2_slots();
		if (waist != null) num += waist.getNum_level2_slots();
		if (leg != null) num += leg.getNum_level2_slots();
		return num;
	}

	public Integer getNum_level3_slots() {
		int num = 0;
		if (head != null) num += head.getNum_level3_slots();
		if (chest != null) num += chest.getNum_level3_slots();
		if (arm != null) num += arm.getNum_level3_slots();
		if (waist != null) num += waist.getNum_level3_slots();
		if (leg != null) num += leg.getNum_level3_slots();
		return num;
	}

	public String getSkill_desc() {
		return getSkillsDescription();
	}
	
	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public Integer getDefense() {
		defense = 0;
		defense += (head == null)? 0 : head.getDefense_augment_max();
		defense += (chest == null)? 0 : chest.getDefense_augment_max();
		defense += (arm == null)? 0 : arm.getDefense_augment_max();
		defense += (waist == null)? 0 : waist.getDefense_augment_max();
		defense += (leg == null)? 0 : leg.getDefense_augment_max();
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getFire_res() {
		fire_res = 0;
		fire_res += (head == null)? 0 : head.getDefense_fire();
		fire_res += (chest == null)? 0 : chest.getDefense_fire();
		fire_res += (arm == null)? 0 : arm.getDefense_fire();
		fire_res += (waist == null)? 0 : waist.getDefense_fire();
		fire_res += (leg == null)? 0 : leg.getDefense_fire();
		return fire_res;
	}

	public void setFire_res(Integer fire_res) {
		this.fire_res = fire_res;
	}

	public Integer getWater_res() {
		water_res = 0;
		water_res += (head == null)? 0 : head.getDefense_water();
		water_res += (chest == null)? 0 : chest.getDefense_water();
		water_res += (arm == null)? 0 : arm.getDefense_water();
		water_res += (waist == null)? 0 : waist.getDefense_water();
		water_res += (leg == null)? 0 : leg.getDefense_water();
		return water_res;
	}

	public void setWater_res(Integer water_res) {
		this.water_res = water_res;
	}

	public Integer getThunder_res() {
		thunder_res = 0;
		thunder_res += (head == null)? 0 : head.getDefense_thunder();
		thunder_res += (chest == null)? 0 : chest.getDefense_thunder();
		thunder_res += (arm == null)? 0 : arm.getDefense_thunder();
		thunder_res += (waist == null)? 0 : waist.getDefense_thunder();
		thunder_res += (leg == null)? 0 : leg.getDefense_thunder();
		return thunder_res;
	}

	public void setThunder_res(Integer thunder_res) {
		this.thunder_res = thunder_res;
	}

	public Integer getIce_res() {
		ice_res = 0;
		ice_res += (head == null)? 0 : head.getDefense_ice();
		ice_res += (chest == null)? 0 : chest.getDefense_ice();
		ice_res += (arm == null)? 0 : arm.getDefense_ice();
		ice_res += (waist == null)? 0 : waist.getDefense_ice();
		ice_res += (leg == null)? 0 : leg.getDefense_ice();
		return ice_res;
	}

	public void setIce_res(Integer ice_res) {
		this.ice_res = ice_res;
	}

	public Integer getDragon_res() {
		dragon_res = 0;
		dragon_res += (head == null)? 0 : head.getDefense_dragon();
		dragon_res += (chest == null)? 0 : chest.getDefense_dragon();
		dragon_res += (arm == null)? 0 : arm.getDefense_dragon();
		dragon_res += (waist == null)? 0 : waist.getDefense_dragon();
		dragon_res += (leg == null)? 0 : leg.getDefense_dragon();
		return dragon_res;
	}

	public void setDragon_res(Integer dragon_res) {
		this.dragon_res = dragon_res;
	}

	public Armorset(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public Armor getHead() {
		return head;
	}

	public void setHead(Armor head) {
		this.head = head;
	}

	public Armor getChest() {
		return chest;
	}

	public void setChest(Armor chest) {
		this.chest = chest;
	}

	public Armor getArm() {
		return arm;
	}

	public void setArm(Armor arm) {
		this.arm = arm;
	}

	public Armor getWaist() {
		return waist;
	}

	public void setWaist(Armor waist) {
		this.waist = waist;
	}

	public Armor getLeg() {
		return leg;
	}

	public void setLeg(Armor leg) {
		this.leg = leg;
	}

	public Skill getBonus() {
		return bonus;
	}

	public void setBonus(Skill bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		String ret = String.format("name = %s; head = %s; chest = %s; arm = %s; waist = %s; leg = %s;", 
				name, (head == null)? "null": head.getName(), (chest == null)? "null": chest.getName(), 
				(arm == null)? "null": arm.getName(), (waist == null)? "null": waist.getName(), (leg == null)? "null": leg.getName());
		return ret;
	}
	
	public String getSkillsDescription() {
		Map<String, Integer> skills = new HashMap<String, Integer>();
		Armor[] parts = {head, chest, arm, waist, leg};
		for (Armor part: parts) {
			if (part == null) continue;
			if (part.getSkill1() != null) {
				String name = part.getSkill1().getName();
				Integer level = part.getSkill1().getLevel();
				if (skills.containsKey(name)) skills.put(name, skills.get(name) + level);
				else skills.put(name, level);
			}
			if (part.getSkill2() != null) {
				String name = part.getSkill2().getName();
				Integer level = part.getSkill2().getLevel();
				if (skills.containsKey(name)) skills.put(name, skills.get(name) + level);
				else skills.put(name, level);
			}
		}
		
		StringBuilder ret = new StringBuilder();
		for (Map.Entry<String, Integer> entry : skills.entrySet()) {
			ret.append(String.format("%s: %d\n", entry.getKey(), entry.getValue()));
		}
		return ret.toString();
	}

	public Map<String, Object> getAttributeMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("armorset_name", this.getName());
		map.put("fire_res", this.getFire_res());
		map.put("water_res", this.getWater_res());
		map.put("thunder_res", this.getThunder_res());
		map.put("ice_res", this.getIce_res());
		map.put("dragon_res", this.getDragon_res());
		map.put("num_lvl1_slots", this.getNum_level1_slots());
		map.put("num_lvl2_slots", this.getNum_level2_slots());
		map.put("num_lvl3_slots", this.getNum_level3_slots());
		map.put("skill_map", this.getSkill_map());
		map.put("set_img_path", this.getImg_path());
		return map;
	}
	
	public static Comparator<Armorset> getComparator(String type){
		if (type.equals("name")) {
			return new Comparator<Armorset>(){
				@Override
				public int compare(Armorset a1, Armorset a2) {
					return a1.getName().compareTo(a2.getName());
				}
			};
		}else {
			return new Comparator<Armorset>() {
				@Override
				public int compare(Armorset a1, Armorset a2) {
					return a1.getDefense().compareTo(a2.getDefense());
				}
			};
		}
	}

	public Map<String, Armor> getPieces(){
		Map<String, Armor> pieces = new HashMap<String, Armor>();
		if (head != null) pieces.put("head", head);
		if (chest != null) pieces.put("chest", chest);
		if (arm != null) pieces.put("arm", arm);
		if (waist != null) pieces.put("waist", waist);
		if (leg != null) pieces.put("leg", leg);
		return pieces;
	}
}
