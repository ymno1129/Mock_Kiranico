package com.kiranico.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.kiranico.entities.Armor;
import com.kiranico.entities.Armorset;

public class ArmorFactory {
	private static ArmorFactory af;
	private Database db;
	private static QueryFetcher qf;
	
	private List<Armor> all_armors;
	private Map<String, Armor> armor_map;
	private Map<String, Armorset> armorset_map;
	
	private ArmorFactory() {
		db = Database.getDatabaseInstance();
		qf = QueryFetcher.getQueryFetcherInstance();
		all_armors = new ArrayList<Armor>();
		armor_map = new HashMap<String, Armor>();
		armorset_map = new HashMap<String, Armorset>();
	}
	
	public static ArmorFactory getInstance() {
		if (af == null) af = new ArmorFactory();
		return af;
	}
	
	public List<Armor> getAllArmors() {
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
				//System.out.println((head == null));
				String[] components = {head, chest, arm, waist, leg};	
				
				//Construct the armorset with its corresponding pieces
				if (!armorset_map.containsKey(name)) {
					Armorset as = new Armorset(name);
					
					//Iterate through all components to make sure every piece is in the data structure.
					for (int i = 0; i < components.length; i ++) {
						if (components[i] == null) continue;
						String c = components[i];
						if (!armor_map.containsKey(c)) {
							s = db.getSession();
							query = qf.fetchQueryByString("getArmorPiece");
							nq = s.createSQLQuery(query).addEntity(Armor.class);
							List<Armor> matched_armors = nq.getResultList();
							if (!matched_armors.isEmpty()) {
								armor_map.put(c, matched_armors.get(0));
							}
						}
						Armor piece = armor_map.get(c);
						switch (i) {
						case 0:
							as.setHead(piece);
							break;
						case 1:
							as.setChest(piece);
							break;
						case 2:
							as.setArm(piece);
							break;
						case 3:
							as.setWaist(piece);
							break;
						case 4:
							as.setLeg(piece);
							break;
						}
						//TODO BONUS needs to be a skill at this point.
					}
					armorsets.add(as);
				}
			}
		}
		return armorsets;
	}
}
