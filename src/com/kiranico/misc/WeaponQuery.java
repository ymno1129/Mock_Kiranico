package com.kiranico.misc;

public class WeaponQuery {
	private String weapon_type;
	private String element;
	private Integer num_slots;
	
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
		return String.format("%s: %s %d", weapon_type, element, num_slots);
	}
	
}
