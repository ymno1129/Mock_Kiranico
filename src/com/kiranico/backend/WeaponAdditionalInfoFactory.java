package com.kiranico.backend;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kiranico.entities.AmmoInfo;
import com.kiranico.entities.Melody;

public class WeaponAdditionalInfoFactory {
	private static final String weapon_all_melodies_path = "/com/kiranico/backend/weapon_all_melodies.json";
	private static final String ammo_map_path = "/com/kiranico/backend/name_ammo_map.json"; 
	private final String weapon_image_path = "/com/kiranico/backend/weapon_img_map.json";
	
	private Database db;
	private static QueryFetcher query_fetcher;
	private static WeaponAdditionalInfoFactory factory;
	
	private final int MELODY = 0;
	private final int AMMO = 1;
	private final int WEAPON_IMAGE = 2;
	
	private WeaponAdditionalInfoFactory() {
		db = Database.getDatabaseInstance();
		query_fetcher = QueryFetcher.getQueryFetcherInstance();
	}
	
	private JSONObject getJsonObject(int category) {
		String curr_dir = Paths.get("").toAbsolutePath().toString();
		StringBuilder path = new StringBuilder(curr_dir);
		switch (category) {
		case MELODY:
			path.append(weapon_all_melodies_path);
			break;
		case AMMO:
			path.append(ammo_map_path);
			break;
		case WEAPON_IMAGE:
			path.append(weapon_image_path);
			break;
		default:
			break;
		}
		
		try {
			Object obj = new JSONParser().parse(new FileReader(path.toString()));
			JSONObject jobj = (JSONObject) obj;
			return jobj;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static WeaponAdditionalInfoFactory getInstance() {
		if (factory == null) factory = new WeaponAdditionalInfoFactory();
		return factory;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AmmoInfo getAmmoInfoByName(String weapon_name) {
		Session s = db.getSession();
		JSONObject jobj = getJsonObject(AMMO);
		
		if (!jobj.containsKey(weapon_name)) {
			System.out.println(String.format("%s is not found", weapon_name));
			return null;
		}
		
		String weapon_key = (String)jobj.get(weapon_name);
		String query_template = query_fetcher.fetchQueryByString("getAmmoInfoByWeaponKey");
		NativeQuery nq = s.createSQLQuery(query_template).addEntity(AmmoInfo.class).setParameter("weapon_key", weapon_key);
		List<AmmoInfo> results = nq.getResultList();
		if (!results.isEmpty()) {
			AmmoInfo info = results.get(0);
			return info;
		}
		
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Melody> getMelodiesByName(String weapon_name){
		Session s = db.getSession();
		JSONObject jobj = getJsonObject(MELODY);
		
		//Some weapons have weird characters so queries won't always get desired results.
		//Return an empty list in that case.
		if (!jobj.containsKey(weapon_name)) {
			return new ArrayList<Melody>();
		}
		
		List<String> weapon_melodies = (List<String>)jobj.get(weapon_name);
		String query_template = query_fetcher.fetchQueryByString("getMelodyByNotes");
		List<Melody> melodies = new ArrayList<Melody>();
		for (String notes: weapon_melodies) {
			NativeQuery nq = s.createSQLQuery(query_template).addEntity(Melody.class).setParameter("notes", notes);
			List<Melody> results = nq.getResultList();
			if (!results.isEmpty()) {
				Melody m = results.get(0);
				melodies.add(m);
			}
		}
		Collections.sort(melodies, Melody.getComparator());
		return melodies;
	}

	public String getWeaponImagePath(String weapon_name) {
		JSONObject jobj = getJsonObject(WEAPON_IMAGE);
		weapon_name = weapon_name.replace("\"", "");
		weapon_name = weapon_name.replace("\'", "");
		if (jobj.containsKey(weapon_name)) {
			return (String)jobj.get(weapon_name);
		}else {
			return null;
		}
	}
}
