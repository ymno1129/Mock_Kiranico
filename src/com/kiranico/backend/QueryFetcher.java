package com.kiranico.backend;

import java.io.FileReader;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kiranico.entities.WeaponQuery;

public class QueryFetcher {
	private static final String query_path = "/com/kiranico/backend/sql_queries.json";
	private static QueryFetcher qf;
	private static JSONObject jobj;
	
	private QueryFetcher() {
		try {
			String curr_dir = Paths.get("").toAbsolutePath().toString();
			StringBuilder path = new StringBuilder();
			path.append(curr_dir);
			path.append(query_path);
			Object obj = new JSONParser().parse(new FileReader(path.toString()));
			jobj = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static QueryFetcher getQueryFetcherInstance() {
		if (qf == null) { qf = new QueryFetcher();}
		return qf;
	}
	
	public String fetchQueryByString(String req) {
		if (jobj.containsKey(req)) {
			String query = (String)jobj.get(req);
			return query;
		}else {
			return "";
		}
	}
	
}
