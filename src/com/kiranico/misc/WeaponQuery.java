package com.kiranico.misc;

public class WeaponQuery {
	private String weapon_type;
	private String element;
	private String affinity;
	private Integer num_slots;
	private String additional_info;
	
	public String getAdditional_info() {
		return additional_info;
	}
	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}
	public Integer getAffinity() {
		return affinity.equals("--")? -100 : Integer.parseInt(affinity);
	}
	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}
	public String getWeapon_type() {
		return weapon_type;
	}
	public void setWeapon_type(String weapon_type) {
		this.weapon_type = weapon_type;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public Integer getNum_slots() {
		return num_slots;
	}
	public void setNum_slots(Integer num_slots) {
		this.num_slots = num_slots;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s %d %d", weapon_type, element, this.getAffinity(), num_slots);
	}
	
}
