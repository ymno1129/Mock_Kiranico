package com.kiranico.entities;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.kiranico.misc.WeaponQuery;

/**
 * @author ymno1
 *
 */
@Entity
@Table(name="weapon_base")
public class Weapon {
	@Id
	private Integer id;
	private String name;
	private String weapon_type;
	private String previous;
	private String category;
	private Integer rarity;
	private Integer attack;
	private Integer affinity;
	private Integer defense;
	private Boolean element_hidden;
	private String element1;
	private Integer element1_atk;
	private String element2;
	private Integer element2_atk;
	private String elderseal;
	private Integer slot_1;
	private Integer slot_2;
	private Integer slot_3;
	private String kinsect_bonus;
	private String phial;
	private String phial_power;
	private String shelling;
	private Integer shelling_level;
	private String notes;
	private String ammo_config;
	private String skill;
	
	@Transient
	private ArrayList<Weapon> next;
	@Transient
	private Weapon prev;
	
	public HashMap<String, Integer> getMaterials() {
		return materials;
	}

	public void setMaterials(HashMap<String, Integer> materials) {
		this.materials = materials;
	}

	public void addMaterial(String mat, Integer num) {
		if (!materials.containsKey(mat)) {
			materials.put(mat, num);
		}
	}
	
	@Transient
	private HashMap<String, Integer> materials;
	
	public Weapon() {
		this.next = new ArrayList<Weapon>();
		this.materials = new HashMap<String, Integer>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon_type() {
		return weapon_type;
	}

	public void setWeapon_type(String weapon_type) {
		this.weapon_type = weapon_type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getRarity() {
		return rarity;
	}

	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getAffinity() {
		return affinity;
	}

	public void setAffinity(Integer affinity) {
		this.affinity = affinity;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Boolean getElement_hidden() {
		return element_hidden;
	}

	public void setElement_hidden(Boolean element_hidden) {
		this.element_hidden = element_hidden;
	}

	public String getElement1() {
		return element1;
	}

	public void setElement1(String element1) {
		this.element1 = element1;
	}

	public Integer getElement1_atk() {
		return element1_atk;
	}

	public void setElement1_atk(Integer element1_atk) {
		this.element1_atk = element1_atk;
	}

	public String getElement2() {
		return element2;
	}

	public void setElement2(String element2) {
		this.element2 = element2;
	}

	public Integer getElement2_atk() {
		return element2_atk;
	}

	public void setElement2_atk(Integer element2_atk) {
		this.element2_atk = element2_atk;
	}

	public String getElderseal() {
		return elderseal;
	}

	public void setElderseal(String elderseal) {
		this.elderseal = elderseal;
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

	public String getKinsect_bonus() {
		return kinsect_bonus;
	}

	public void setKinsect_bonus(String kinsect_bonus) {
		this.kinsect_bonus = kinsect_bonus;
	}

	public String getPhial() {
		return phial;
	}

	public void setPhial(String phial) {
		this.phial = phial;
	}

	public String getPhial_power() {
		return phial_power;
	}

	public void setPhial_power(String phial_power) {
		this.phial_power = phial_power;
	}

	public String getShelling() {
		return shelling;
	}

	public void setShelling(String shelling) {
		this.shelling = shelling;
	}

	public Integer getShelling_level() {
		return shelling_level;
	}

	public void setShelling_level(Integer shelling_level) {
		this.shelling_level = shelling_level;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAmmo_config() {
		return ammo_config;
	}

	public void setAmmo_config(String ammo_config) {
		this.ammo_config = ammo_config;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public ArrayList<Weapon> getNext() {
		return next;
	}

	public void setNext(ArrayList<Weapon> next) {
		this.next = next;
	}

	public Weapon getPrev() {
		return this.prev;
	}

	public void setPrev(Weapon prev) {
		this.prev = prev;
	}
	
	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public void addNext(Weapon w) {
		this.next.add(w);
	}
	
	public boolean hasNext() {
		return !(this.next.isEmpty());
	}
	
	public boolean hasPrev() {
		return !(this.previous == null);
	}
	
	public boolean materialsLoaded() {
		return !materials.isEmpty();
	}
	
	@Override
	public String toString() {
		String repr = String.format("%s [%s->]: %d %s %d [%d]", this.name, this.previous, this.attack, this.element1, this.element1_atk, this.rarity);
		return repr;
	}

	public static Comparator<Weapon> getComparator(String type){
		if (type.equals("attack")) {
			return new Comparator<Weapon>(){
				@Override
				public int compare(Weapon w1, Weapon w2) {
					return w2.getAttack() - w1.getAttack();
				}
			};
		}else if (type.equals("element")) {
			return new Comparator<Weapon>(){
				@Override
				public int compare(Weapon w1, Weapon w2) {
					String w2_ele = w2.getElement1();
					String w1_ele = w1.getElement1();
					if (w2_ele == null) return -1;
					if (w1_ele == null) return 1;
					return w2_ele.compareTo(w1_ele);
				}
			};
		}else if (type.equals("element_atk")) {
			return new Comparator<Weapon>(){
				@Override
				public int compare(Weapon w1, Weapon w2) {
					Integer w1_ele = w1.getElement1_atk();
					Integer w2_ele = w2.getElement1_atk();
					if (w2_ele == null) return -1;
					if (w1_ele == null) return 1;
					return w2_ele - w1_ele;
				}
			};
		}else if (type.equals("rarity")) {
			return new Comparator<Weapon>(){
				@Override
				public int compare(Weapon w1, Weapon w2) {
					return w2.getRarity() - w1.getRarity();
				}
			};
		}else {
			return null;
		}
	}
	
	public int getNumSlots() {
		int s1 = this.slot_1 > 0? 1 : 0;
		int s2 = this.slot_2 > 0? 1 : 0;
		int s3 = this.slot_3 > 0? 1 : 0;
		return s1 + s2 + s3;
	}
	
	public boolean meetRequirement(WeaponQuery wq) {
		String comp = String.format("%s, %d, %s == %s?", this.getWeapon_type(), this.getAttack(), this.getElement1(), wq.toString());
		System.out.println(comp);
		return (wq.getWeapon_type().equalsIgnoreCase(this.getWeapon_type()) && 
				(wq.getElement().equalsIgnoreCase(this.getElement1()) || wq.getElement().equalsIgnoreCase(this.getElement2())) &&
				this.getNumSlots() >= wq.getNum_slots());
	}
	
	public HashMap<String, Object> getAttributesMap(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//Construct "slots"
		int[] slots = {this.slot_1, this.slot_2, this.slot_3};
		StringBuilder slotString = new StringBuilder();
		for (int i = 0; i < slots.length; i ++) {
			if (slots[i] == 0) {
				slotString.append("-"); 
			}else {
				slotString.append(Integer.toString(slots[i]));
			}
		}
		
		//Construct "element"
		String element_img_path = "";
		//StringBuilder elementString = new StringBuilder();
		String elementString = "";
		boolean isHidden = this.element_hidden;
		String ele1 = this.element1;
		Integer ele1_atk = this.element1_atk;
		if (ele1_atk == null) {
			elementString = "-";
			element_img_path = "none";
		}else {
			if (isHidden) {
				elementString = String.format("(%s) %s", Integer.toString(ele1_atk), ele1.toLowerCase());
			}else {
				elementString = String.format("%s %s", Integer.toString(ele1_atk), ele1.toLowerCase());
			}
			element_img_path = ele1.toLowerCase() + ".png";
		}
		
		StringBuilder weapon_img_path = new StringBuilder();
		String curr_dir = Paths.get("").toAbsolutePath().toString();
		String img_filename = this.name + ".png";
		img_filename = "buster_sword.png";
		weapon_img_path.append(curr_dir + "\\" + img_filename);
		
		map.put("name", this.name);
		map.put("attack", this.attack);
		map.put("element", elementString.toString());
		map.put("affinity", Integer.toString(this.affinity) + "%");
		map.put("slots", slotString.toString());
		map.put("rarity", this.rarity);
		map.put("materials", this.materials);
		map.put("weapon_type", this.weapon_type);
		map.put("img_path", weapon_img_path.toString());
		map.put("element_img_path", element_img_path);
		
		return map;
	}
}
