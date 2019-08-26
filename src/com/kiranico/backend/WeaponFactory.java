package com.kiranico.backend;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.kiranico.entities.Weapon;
import com.kiranico.misc.WeaponQuery;

public class WeaponFactory {
	private final int ALL = 0;
	private final int TOP = 1;
	private final int BOTTOM = 2;
	
	private static Database db;
	private static WeaponFactory weapon_factory;
	private static QueryFetcher query_fetcher;
	
	private HashMap<String, List<Weapon>> bottomLevelWeapons;
	private HashMap<String, List<Weapon>> topLevelWeapons; 	
	private HashMap<String, List<Weapon>> allWeapons; 
	private HashMap<String, Weapon> weaponLibrary;
	
	private List<Weapon> current_displayed; 
	
	public List<Weapon> getCurrent_displayed() {
		return current_displayed;
	}

	private WeaponFactory() {
		db = Database.getDatabaseInstance();
		query_fetcher = QueryFetcher.getQueryFetcherInstance();
		
		weaponLibrary = new HashMap<String, Weapon>();
		bottomLevelWeapons = new HashMap<String, List<Weapon>>();
		topLevelWeapons = new HashMap<String, List<Weapon>>();
		allWeapons = new HashMap<String, List<Weapon>>();
	}
	
	public static WeaponFactory getWeaponFactoryInstance() {
		if (weapon_factory == null) {
			weapon_factory = new WeaponFactory();
		}
		return weapon_factory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Weapon> getWeaponsByType(String type, int mode){
		String requirement = "";
		
		//Hasn't been queried before, so make the query and construct corresponding data structures.
		if (!allWeapons.containsKey(type)) {
			requirement = "getOneCategory";
			//System.out.println("FIRST TIME QUERY");
			Session s = db.getSession();
			String query = query_fetcher.fetchQueryByString(requirement);
			NativeQuery<Weapon> nq = s.createSQLQuery(query).addEntity(Weapon.class).setParameter("type", type);
			List<Weapon> results = nq.getResultList();
			allWeapons.put(type, results);
			for (Weapon w: results) {
				weaponLibrary.put(w.getName(), w);
			}
			
			constructWeaponHierarchy(type);
		}	
		
		//System.out.println("HAS BEEN QUERIED BEFORE");
		List<Weapon> empty = new ArrayList<Weapon>();
		switch (mode) {
		case ALL:
			if (allWeapons.containsKey(type)) {
				current_displayed = allWeapons.get(type);
				return allWeapons.get(type);
			}
			return empty;
		case TOP:
			if (topLevelWeapons.containsKey(type)) {
				current_displayed = topLevelWeapons.get(type);
				return topLevelWeapons.get(type);
			}
			return empty;
		case BOTTOM:
			if (bottomLevelWeapons.containsKey(type)) {
				current_displayed = bottomLevelWeapons.get(type);
				return bottomLevelWeapons.get(type);
			}
			return empty;
		default:
			return empty;
		}
	}
		
	public void setCurrent_displayed(List<Weapon> current_displayed) {
		this.current_displayed = current_displayed;
	}

	@SuppressWarnings("unchecked")
	public Weapon getWeapon(String name) {
		if (weaponLibrary.containsKey(name)) {
			Weapon w = weaponLibrary.get(name);
			if (!w.materialsLoaded()) loadWeaponMaterials(name);
			return w;
		}else {
			//Normally this branch will not be reached since the weapon should already be in the map at this point
			//In case something weird happens, query directly and return
			Session s = db.getSession();
			String query = query_fetcher.fetchQueryByString("getOneWeapon");
			NativeQuery<Weapon> nq = s.createSQLQuery(query).addEntity(Weapon.class).setParameter("name", name);
			List<Weapon> results = nq.getResultList();
			if (!results.isEmpty()) {
				return results.get(0);
			}else {
				System.err.println(String.format("Duplicate weapon name discovered. Name is [%s]", name));
				return null;
			}
			
		}
	}
	
	public List<Weapon> getWeaponFamily(String name){
		List<Weapon> family = new ArrayList<Weapon>();
		if (weaponLibrary.containsKey(name)) {
			Weapon target = weaponLibrary.get(name);
			Deque<Weapon> hierarchy = new LinkedList<Weapon>();
			
			Weapon tmp = target;
			while (tmp.hasPrev()) {
				tmp = tmp.getPrev();
				hierarchy.addFirst(tmp);
			}
			hierarchy.addLast(target);
			tmp = target;
			while (tmp.hasNext()) {
				List<Weapon> nexts = tmp.getNext();
				tmp = nexts.get(0);
				hierarchy.addLast(tmp);
			}
			family = new ArrayList<Weapon>(hierarchy);
		}
		return family;
	}
	
	public List<Weapon> getWeaponsByRequirements(WeaponQuery wq){
		String weapon_type = wq.getWeapon_type();
		
		if (!allWeapons.containsKey(weapon_type)) {
			getWeaponsByType(weapon_type, TOP);
		}

		List<Weapon> weapons = allWeapons.get(weapon_type);
		List<Weapon> filtered = new ArrayList<Weapon>();
		for (Weapon w: weapons) {
			if (w.meetRequirement(wq) && !w.hasNext()) filtered.add(w);
		}
		current_displayed = filtered;
		return filtered;
	}
	
	@SuppressWarnings("unused")
	private void constructWeaponHierarchy(String type) {
		if (!allWeapons.containsKey(type)) return;
		List<Weapon> all_weapons = allWeapons.get(type);
		
		for (Weapon w: all_weapons) {
			String this_name = w.getName();
			String prev_name = "";
			if (w.getPrevious() != null) prev_name = w.getPrevious();
			if (!prev_name.equals("")) {
				Weapon prev_weapon = weaponLibrary.get(prev_name);
				prev_weapon.addNext(w);
				w.setPrev(prev_weapon);
			}
		}
		
		for (Weapon w: all_weapons) {
			//No next means top level
			if (!w.hasNext()) {
				if (topLevelWeapons.containsKey(type)) {
					topLevelWeapons.get(type).add(w);
				}else {
					List<Weapon> l = new ArrayList<Weapon>();
					l.add(w);
					topLevelWeapons.put(type, l);
				}
			}
			
			//No prev means bottom level
			if (!w.hasPrev()) {
				if (bottomLevelWeapons.containsKey(type)) {
					bottomLevelWeapons.get(type).add(w);
				}else {
					List<Weapon> l = new ArrayList<Weapon>();
					l.add(w);
					bottomLevelWeapons.put(type, l);
				}
			}
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadWeaponMaterials(String name) {

		if (!weaponLibrary.containsKey(name)) return;
		Session s = db.getSession();
		Weapon w = weaponLibrary.get(name);
		String query = query_fetcher.fetchQueryByString("getWeaponMaterials");
		NativeQuery nq = s.createSQLQuery(query).setParameter("name", w.getName());
		List<Object[]> results = nq.getResultList();
		if (results.isEmpty()) return;
		
		Object[] result = results.get(0);
		//0: name, 1: upgrade/create, 2-9:(name, count)
		for (int i = 2; i < result.length - 1;) {
			if (result[i] == null) break;
			String matName = (String)result[i];
			Integer matCount = ((Byte)result[i + 1]).intValue();
			w.addMaterial(matName, matCount);
			//System.out.println(String.format("%d [%s]", matCount, matName));
			i += 2;
		}
	}
}










