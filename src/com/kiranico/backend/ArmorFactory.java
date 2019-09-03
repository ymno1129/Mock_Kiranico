package com.kiranico.backend;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.kiranico.entities.Armor;

public class ArmorFactory {
	private static ArmorFactory af;
	private Database db;
	private static QueryFetcher qf;
	
	private List<Armor> all_armors;
	
	private ArmorFactory() {
		db = Database.getDatabaseInstance();
		qf = QueryFetcher.getQueryFetcherInstance();
		all_armors = new ArrayList<Armor>();
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
		System.out.println(armors.size());
		if (!armors.isEmpty()) {
			for (Armor armor: armors) {
				System.out.println(armor);
			}
		}
		return armors;
	}
	
}
