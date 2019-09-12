package com.kiranico.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.kiranico.entities.Armor;
import com.kiranico.entities.Armorset;
import com.kiranico.entities.Skill;
import com.kiranico.entities.Weapon;

public class ArmorFactory {
	private static ArmorFactory af;
	private Database db;
	private static QueryFetcher qf;
	
	private List<Armor> all_armors;
	private Map<String, Armor> armor_map;
	private Map<String, Armorset> armorset_map;
	private Map<String, Map<Integer, String>> skill_dict;
	private Map<String, String> armor_category_map;
	
	private ArmorFactory() {
		db = Database.getDatabaseInstance();
		qf = QueryFetcher.getQueryFetcherInstance();
		all_armors = new ArrayList<Armor>();
		armor_map = new HashMap<String, Armor>();
		armorset_map = new HashMap<String, Armorset>();
		skill_dict = new HashMap<String, Map<Integer, String>>();
		armor_category_map = new HashMap<String, String>();
	}
	
	public static ArmorFactory getInstance() {
		if (af == null) af = new ArmorFactory();
		return af;
	}
	
	public void loadSkillDict() {
		if (!skill_dict.isEmpty()) return;
		
		Session s= db.getSession();
		String query = qf.fetchQueryByString("getAllSkills");
		NativeQuery nq = s.createSQLQuery(query);
		List<Object[]> results = nq.getResultList();
		for (Object[] result: results) {
			if (result.length == 0 || result.length != 4) continue;
			//System.out.println(String.format("%s, %s, %s", (String)result[1], ((Byte)result[2]).toString(), (String)result[3]));
			String skill_name = (String)result[1];
			Integer level = ((Byte)result[2]).intValue();
			String description = (String)result[3];
			if (skill_dict.containsKey(skill_name)) {
				skill_dict.get(skill_name).put(level, description);
			}else {
				Map<Integer, String> level_dict = new HashMap<Integer, String>();
				level_dict.put(level, description);
				skill_dict.put(skill_name, level_dict);
			}
		}
		
	}
	
	public List<Armor> getAllArmors() {
		loadSkillDict();
		
		Session s = db.getSession();
		String query = qf.fetchQueryByString("getAllArmors");
		NativeQuery nq = s.createSQLQuery(query).addEntity(Armor.class);	
		List<Armor> armors = nq.getResultList();
		if (!armors.isEmpty()) {
			for (Armor armor: armors) {
				armor_map.put(armor.getName(), armor);
			}
		}
		return armors;
	}
	
	public List<Armorset> getAllArmorsets(){
		loadSkillDict();
		
		if (!armorset_map.isEmpty()) {
			List<Armorset> to_ret = new ArrayList<Armorset>(armorset_map.values());
			Collections.sort(to_ret, Armorset.getComparator("name"));
			return to_ret;
		}
		
		List<Armorset> armorsets = new ArrayList<Armorset>();
		
		//Get all armors first
		Session s = db.getSession();
		String query = qf.fetchQueryByString("getAllArmors");
		NativeQuery nq = s.createSQLQuery(query).addEntity(Armor.class);	
		List<Armor> armors = nq.getResultList();
		if (!armors.isEmpty()) {
			for (Armor armor: armors) {
				armor_map.put(armor.getName(), armor);
			}
		}
		
		//Get all armorests
		query = qf.fetchQueryByString("getAllArmorsets");
		nq = s.createSQLQuery(query);
		List<Object[]> results = nq.getResultList();
		if (!results.isEmpty()) {
			System.out.println(String.format("Got %d results", results.size()));
			for (Object[] result: results) {
				if (result.length != 8) continue;
				String name = (String)result[0];
				String monster = (String)result[1];
				String head = (String)result[2];
				String chest = (String)result[3];
				String arm = (String)result[4];
				String waist = (String)result[5];
				String leg = (String)result[6];
				String bonus = (String)result[7];
				//System.out.println(String.format("%s, %s, %s, %s, %s", head, chest, arm, waist, leg));
				String[] components = {head, chest, arm, waist, leg};	
				
				//Construct the armorset with its corresponding pieces
				if (!armorset_map.containsKey(name)) {
					Armorset as = new Armorset(name);
					
					//Iterate through all components to make sure every piece is in the data structure.
					for (int i = 0; i < components.length; i ++) {
						if (components[i] == null) continue;
						String c = components[i];
						
						//If the armor does not exist already, load it individually
						//Won't happend normally tho.
						if (!armor_map.containsKey(c)) {
							s = db.getSession();
							query = qf.fetchQueryByString("getArmorPiece");
							nq = s.createSQLQuery(query).addEntity(Armor.class).setParameter("name", c);
							List<Armor> matched_armors = nq.getResultList();
							
							if (!matched_armors.isEmpty()) {
								Armor target = matched_armors.get(0);
								armor_map.put(c, target);
							}
						}
						
						//Bind skills to the armor piece
						Armor target = armor_map.get(c);
						String[] skill_names = {target.getSkill1_name(), target.getSkill2_name()};	
						Integer[] skill_levels = {target.getSkill1_pts(), target.getSkill2_pts()};
						List<Skill> armor_skills = new ArrayList<Skill>();
						for (int k = 0; k < skill_names.length; k ++) {
							String skill_name = skill_names[k];
							Integer skill_level = skill_levels[k];
							if (skill_name != null && skill_dict.containsKey(skill_name) && skill_dict.get(skill_name).containsKey(skill_level)) {
								String desc = skill_dict.get(skill_name).get(skill_level);
								Skill sk = new Skill(skill_name, skill_level, desc);
								armor_skills.add(sk);
							}
						}
						if (armor_skills.size() == 1) {
							target.setSkill1(armor_skills.get(0));
						}else if (armor_skills.size() == 2) {
							target.setSkill1(armor_skills.get(0));
							target.setSkill2(armor_skills.get(1));
						}
						
						switch (i) {
						case 0:
							as.setHead(target);
							break;
						case 1:
							as.setChest(target);
							break;
						case 2:
							as.setArm(target);
							break;
						case 3:
							as.setWaist(target);
							break;
						case 4:
							as.setLeg(target);
							break;
						}
						//TODO BONUS needs to be a skill at this point.
					}
					armorsets.add(as);
					armorset_map.put(as.getName(), as);
				}
			}
		}
		return armorsets;
	}

	public Armorset getSingleArmorset(String name) {
		return (armorset_map.containsKey(name))? armorset_map.get(name) : null;
	}
	
	public List<String> getAllSkills(){
		if (skill_dict.isEmpty()) return null;
		List<String> all_skills = new ArrayList<String>(skill_dict.keySet());
		Collections.sort(all_skills);
		return all_skills;
	}
	
}
