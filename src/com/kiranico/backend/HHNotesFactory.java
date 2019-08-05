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

import com.kiranico.entities.Melody;

public class HHNotesFactory {
	private static final String data_path = "/com/kiranico/backend/weapon_all_melodies.json";
	private Database db;
	private static QueryFetcher query_fetcher;
	private static HHNotesFactory hhn_factory;
	private static JSONObject jobj;
	
	private HHNotesFactory() {
		db = Database.getDatabaseInstance();
		query_fetcher = QueryFetcher.getQueryFetcherInstance();
		try {
			String curr_dir = Paths.get("").toAbsolutePath().toString();
			StringBuilder path = new StringBuilder();
			path.append(curr_dir);
			path.append(data_path);
			Object obj = new JSONParser().parse(new FileReader(path.toString()));
			jobj = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static HHNotesFactory getHHNFactoryInstance() {
		if (hhn_factory == null) hhn_factory = new HHNotesFactory();
		return hhn_factory;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Melody> getMelodiesByName(String weapon_name){
		Session s = db.getSession();
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
}
