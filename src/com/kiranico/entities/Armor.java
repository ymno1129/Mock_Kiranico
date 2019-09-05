package com.kiranico.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="armor_combined")
public class Armor {
	@Id
	private String name;
	private String type;
	private String gender;
	private Integer slot_1;
	private Integer slot_2;
	private Integer slot_3;
	private Integer defense_base;
	private Integer defense_max;
	private Integer defense_augment_max;
	private Integer defense_fire;
	private Integer defense_water;
	private Integer defense_thunder;
	private Integer defense_ice;
	private String skill1_name;
	private Integer skill1_pts;
	private String skill2_name;
	private Integer skill2_pts;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name);
		if (skill1_name != null) {
			sb.append(String.format(" %s: %d", skill1_name, skill1_pts));
		}
		if (skill2_name != null) {
			sb.append(String.format(" %s: %d", skill2_name, skill2_pts));
		}
		return sb.toString();
	}
	
	public Integer getSkill2_pts() {
		return skill2_pts;
	}
	public void setSkill2_pts(Integer skill2_pts) {
		this.skill2_pts = skill2_pts;
	}
	public String getSkill1_name() {
		return skill1_name;
	}
	public void setSkill1_name(String skill1_name) {
		this.skill1_name = skill1_name;
	}
	public Integer getSkill1_pts() {
		return skill1_pts;
	}
	public void setSkill1_pts(Integer skill1_pts) {
		this.skill1_pts = skill1_pts;
	}
	public String getSkill2_name() {
		return skill2_name;
	}
	public void setSkill2_name(String skill2_name) {
		this.skill2_name = skill2_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getSlot_1() {
		return slot_1;
	}
	public void setSlot_1(Integer slot_1) {
		this.slot_1 = slot_1;
	}
	public Integer getSlot_2() {
		return slot_2;
	}
	public void setSlot_2(Integer slot_2) {
		this.slot_2 = slot_2;
	}
	public Integer getSlot_3() {
		return slot_3;
	}
	public void setSlot_3(Integer slot_3) {
		this.slot_3 = slot_3;
	}
	public Integer getDefense_base() {
		return defense_base;
	}
	public void setDefense_base(Integer defense_base) {
		this.defense_base = defense_base;
	}
	public Integer getDefense_max() {
		return defense_max;
	}
	public void setDefense_max(Integer defense_max) {
		this.defense_max = defense_max;
	}
	public Integer getDefense_augment_max() {
		return defense_augment_max;
	}
	public void setDefense_augment_max(Integer defense_augment_max) {
		this.defense_augment_max = defense_augment_max;
	}
	public Integer getDefense_fire() {
		return defense_fire;
	}
	public void setDefense_fire(Integer defense_fire) {
		this.defense_fire = defense_fire;
	}
	public Integer getDefense_water() {
		return defense_water;
	}
	public void setDefense_water(Integer defense_water) {
		this.defense_water = defense_water;
	}
	public Integer getDefense_thunder() {
		return defense_thunder;
	}
	public void setDefense_thunder(Integer defense_thunder) {
		this.defense_thunder = defense_thunder;
	}
	public Integer getDefense_ice() {
		return defense_ice;
	}
	public void setDefense_ice(Integer defense_ice) {
		this.defense_ice = defense_ice;
	}
	public Integer getDefense_dragon() {
		return defense_dragon;
	}
	public void setDefense_dragon(Integer defense_dragon) {
		this.defense_dragon = defense_dragon;
	}
	private Integer defense_dragon;
}
