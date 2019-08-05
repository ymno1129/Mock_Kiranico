package com.kiranico.backend;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.kiranico.entities.Material;

public class MaterialFactory {
	private static Database db;
	private static QueryFetcher query_fetcher;
	private static MaterialFactory material_factory;
	
	private HashMap<String, Material> material_dictionary;
	
	private MaterialFactory() {
		db = Database.getDatabaseInstance();
		query_fetcher = QueryFetcher.getQueryFetcherInstance();
		material_dictionary = new HashMap<String, Material>();
		loadAllMaterials();
	}
	
	public static MaterialFactory getMaterialFactoryInstance() {
		if (material_factory == null) material_factory = new MaterialFactory();
		return material_factory;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadAllMaterials() {
		Session s = db.getSession();
		String query = query_fetcher.fetchQueryByString("getAllMaterials");
		NativeQuery nq = s.createSQLQuery(query).addEntity(Material.class);
		List<Material> allMats = nq.getResultList();
		for (Material m: allMats) {
			if (!material_dictionary.containsKey(m.getName())) {
				material_dictionary.put(m.getName(), m);
			}
		}
	}
	
	public Material getMaterialByName(String name) {
		if (material_dictionary.containsKey(name)) return material_dictionary.get(name);
		return null;
	}
	
}
