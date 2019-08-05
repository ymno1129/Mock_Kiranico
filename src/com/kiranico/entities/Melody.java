package com.kiranico.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Melody {
	@Id
	private String notes;
	private String base_name_en;
	private String duration;
	private String extension;
	private String name_en;
	private String effect1;
	private String effect2;
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getBase_name_en() {
		return base_name_en;
	}
	public void setBase_name_en(String base_name_en) {
		this.base_name_en = base_name_en;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getEffect1() {
		return effect1;
	}
	public void setEffect1(String effect1) {
		this.effect1 = effect1;
	}
	public String getEffect2() {
		return effect2;
	}
	public void setEffect2(String effect2) {
		this.effect2 = effect2;
	}
	
	public static Comparator<Melody> getComparator(){
		return new Comparator<Melody>(){
			@Override
			public int compare(Melody m1, Melody m2) {
				return m1.getNotes().compareTo(m2.getNotes());
			}
		};
	}
		
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s", this.notes, this.base_name_en, 
				this.duration, this.extension, this.effect1, this.effect2);
	}
}
