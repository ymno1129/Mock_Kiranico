package com.kiranico.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_base")
public class Material {
	@Id
	private Integer Id;
	private String name;
	private String category;
	private String subcategory;
	private Integer rarity;
	private Integer buy_price;
	private Integer sell_price;
	private Integer carry_limit;
	private Integer point;
	private String icon_name;
	private String icon_color;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Integer getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(Integer buy_price) {
		this.buy_price = buy_price;
	}
	public Integer getSell_price() {
		return sell_price;
	}
	public void setSell_price(Integer sell_price) {
		this.sell_price = sell_price;
	}
	public Integer getCarry_limit() {
		return carry_limit;
	}
	public void setCarry_limit(Integer carry_limit) {
		this.carry_limit = carry_limit;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getIcon_name() {
		return icon_name;
	}
	public void setIcon_name(String icon_name) {
		this.icon_name = icon_name;
	}
	public String getIcon_color() {
		return icon_color;
	}
	public void setIcon_color(String icon_color) {
		this.icon_color = icon_color;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRarity() {
		return rarity;
	}
	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}
}
