package com.kiranico.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdvancedWeaponQuery {
	private String weapon_type;
	private String element;
	private Integer affinity;
	private Integer num_slots;
	private String additional;
	private List<Map<String, String>> bowgun_reqs = new ArrayList<Map<String, String>>();
	
	public AdvancedWeaponQuery(String type, String ele, Integer aff, Integer ns) {
		this.weapon_type = type;
		this.element = ele;
		this.affinity = aff;
		this.num_slots = ns;
	}
	
	public String getAdditional() {
		return additional;
	}
	public void setAdditional(String additional) {
		this.additional = additional;
	}
	public List<Map<String, String>> getBowgun_reqs() {
		return bowgun_reqs;
	}
	public void setBowgun_reqs(List<Map<String, String>> bowgun_reqs) {
		this.bowgun_reqs = bowgun_reqs;
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
	public Integer getAffinity() {
		return affinity;
	}
	public void setAffinity(Integer affinity) {
		this.affinity = affinity;
	}
	public Integer getNum_slots() {
		return num_slots;
	}
	public void setNum_slots(Integer num_slots) {
		this.num_slots = num_slots;
	}
	
	public boolean hasAdditional() {
		return !this.additional.isEmpty();
	}
	
	public boolean hasBowgunRequirement() {
		return !this.bowgun_reqs.isEmpty();
	}
	
	@Override
	public String toString() {
		String ret = String.format("Type = %s\nElement = %s\nAffinity = %d\nNum_Slots = %d\n", 
				this.weapon_type, this.element, this.affinity, this.num_slots);
		StringBuilder sb = new StringBuilder(ret);
		if (this.additional != null) sb.append(String.format("Additional = %s\n", this.additional));
		if (!bowgun_reqs.isEmpty()) {
			int idx = 1;
			for (Map<String, String> m: bowgun_reqs) {
				sb.append(String.format("Bowgun Requirement #%d:\n", idx));
				for (Map.Entry<String, String> e : m.entrySet()) {
					sb.append(String.format("  %s = %s\n", e.getKey(), e.getValue()));
				}
				idx += 1;
			}
		}
		return sb.toString();
	}
}
