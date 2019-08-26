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
	
	public void getMaterialLocations(String name) {
		Session s = db.getSession();
		String monster_query = query_fetcher.fetchQueryByString("getMaterialMonsters");
		String location_query = query_fetcher.fetchQueryByString("getMaterialLocations");
		
		NativeQuery nq_mons = s.createSQLQuery(monster_query).setParameter("name", name);
		NativeQuery nq_loc = s.createSQLQuery(location_query).setParameter("name", name);
		List<Object[]> mons = nq_mons.getResultList();
		System.out.println(String.format("Mons result = %d", mons.size()));
		System.out.println(mons.get(0).length);
		Object[] record = mons.get(0);
		Short id = (Short)record[0];
		String mn = (String)record[1];
		String cond = (String)record[2];
		String rank = (String)record[3];
		String in = (String)record[4];
		
		System.out.println(String.format("%d, %s, %s, %s, %s", id, mn, cond, rank, in));
		
		
	}
}
