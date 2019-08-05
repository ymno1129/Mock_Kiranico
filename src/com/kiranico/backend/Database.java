package com.kiranico.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {
		
	private static Database dbInstance;
	
	private Configuration cfg;
	private SessionFactory sessionFactory;
	
	private Database() {
		cfg = new Configuration();
		sessionFactory = cfg.configure().buildSessionFactory();
	}
	
	public static Database getDatabaseInstance() {
		if (dbInstance == null) {
			dbInstance = new Database();
		}
		return dbInstance;
	}
	
	public Session getSession() {
		Session s = sessionFactory.openSession();
		return s;
	}
}
