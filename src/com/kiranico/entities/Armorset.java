package com.kiranico.entities;

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
}
