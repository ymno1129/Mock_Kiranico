package com.kiranico.misc;

public class AmmoInfoSingle {
	private String ammo_type;
	private Integer capacity;
	private Boolean rapidable;
	private Integer recoil;
	private String reload;
	
	public AmmoInfoSingle(String type, Integer cap, Boolean rap, Integer rec, String rel) {
		this.ammo_type = type;
		this.capacity = cap;
		this.rapidable = rap;
		this.recoil = rec;
		this.reload = rel;
	}
	
	public String getAmmo_type() {
		return ammo_type;
	}
	public void setAmmo_type(String ammo_type) {
		this.ammo_type = ammo_type;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Boolean getRapidable() {
		return rapidable;
	}
	public void setRapidable(Boolean rapidable) {
		this.rapidable = rapidable;
	}
	public Integer getRecoil() {
		return recoil;
	}
	public void setRecoil(Integer recoil) {
		this.recoil = recoil;
	}
	public String getReload() {
		return reload;
	}
	public void setReload(String reload) {
		this.reload = reload;
	}

	
}
