package com.kiranico.misc;

public class AmmoInfoSingle {
	private String ammo_type;
	private Integer capacity;
	private Boolean rapidable;
	private Integer recoil;
	private String reload;

	private String ammo_category;
	private Integer ammo_level;
	private String recoil_level;
	
	public String getRecoil_level() {
		switch (recoil) {
		case -1:
			recoil_level = "Auto";
			break;
		case 1:
			recoil_level = "Low";
			break;
		case 2:
			recoil_level = "Average";
			break;
		case 3:
			recoil_level = "High";
			break;
		case 4:
			recoil_level = "Very High";
			break;
		default:
			recoil_level = "UNK";
			break;
		}
		return recoil_level;
	}

	public void setRecoil_level(String recoil_level) {
		this.recoil_level = recoil_level;
	}

	public String getAmmo_category() {
		return ammo_category.toLowerCase();
	}

	public void setAmmo_category(String ammo_category) {
		this.ammo_category = ammo_category;
	}

	public Integer getAmmo_level() {
		return ammo_level;
	}

	public void setAmmo_level(Integer ammo_level) {
		this.ammo_level = ammo_level;
	}

	public AmmoInfoSingle(String type, Integer cap, Boolean rap, Integer rec, String rel) {
		this.ammo_type = type;
		String[] splited = type.split(" ");
		if (splited.length > 1) {
			this.ammo_category = splited[0];
			this.ammo_level = Integer.parseInt(splited[1]);
		}else {
			this.ammo_category = splited[0];
			this.ammo_level = null;
		}
		
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
