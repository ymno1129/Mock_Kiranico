package com.kiranico.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.WeaponAdditionalInfoFactory;
import com.kiranico.backend.WeaponFactory;
import com.kiranico.entities.AmmoInfo;
import com.kiranico.entities.Weapon;
import com.kiranico.misc.AdvancedWeaponQuery;

@Controller
public class UtilityController {

	private final int ALL = 0;
	private final int TOP = 1;
	private final int BOTTOM = 2;

	@RequestMapping(value="/WeaponFinder")
	public ModelAndView getWeaponFinder() {
		ModelAndView mv = new ModelAndView("WeaponFinder");
		return mv;
	}
	
	@RequestMapping(value="/WeaponFinder/finder_results", method=RequestMethod.POST)
	public ModelAndView getFinderResults(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("WeaponPage");
		Map<String,String[]> params = request.getParameterMap();
		
		List<Map<String, Object>> ammo_req = new ArrayList<Map<String, Object>>();
		
		Map<String, String> string_items = new HashMap<String, String>();
		string_items.put("weapon_type", "");
		string_items.put("element", "dc");
		string_items.put("additional_info", "");
		
		Map<String, Integer> int_items = new HashMap<String, Integer>();
		int_items.put("affinity", 0);
		int_items.put("num_slots", 0);
		
	    for (Map.Entry<String, String> e: string_items.entrySet()) {
	    	String key = e.getKey();
	    	if (params.containsKey(key)) {
				String[] res = params.get(key);
				if (res.length > 0) {
					string_items.put(key, (String)res[0]);
				}
			}
	    }

		//TODO, type check for affinity, shoots a warning in the browser.
	    for (Map.Entry<String, Integer> e: int_items.entrySet()) {
	    	String key = e.getKey();
	    	if (params.containsKey(key)) {
				String[] res = params.get(key);
				if (res.length > 0) {
					String num = (String)res[0];
					try {
						if (num.equals("--")) {
							int_items.put(key, -100);
						} else {
							Integer n = Integer.parseInt(num);
							int_items.put(key, n);
						}
					}catch(Exception exc) {
						exc.printStackTrace();
					}
				}
			}
	    }
		
	    AdvancedWeaponQuery awq = 
	    		new AdvancedWeaponQuery(string_items.get("weapon_type"), string_items.get("element"), 
	    				int_items.get("affinity"), int_items.get("num_slots"));
	    awq.setAdditional(string_items.get("additional_info"));

		//System.out.println(String.format("[%s]", string_items.get("additional_info")));
		
	    if (params.containsKey("ammo_req")) {
			List<Map<String, String>> req_list = new ArrayList<Map<String, String>>();
			String[] reqs = params.get("ammo_req");
			for (String req : reqs) {
				Map<String, String> req_map = new HashMap<String, String>();
				String[] entries = req.split(";");
				for (String entry : entries) {
					String[] pair = entry.trim().split(":");
					req_map.put(pair[0].trim(), pair[1].trim());
				}
				req_list.add(req_map);
			}
			awq.setBowgun_reqs(req_list);
		}
	    
		for (Map.Entry<String, String[]> e:params.entrySet()) {
			//System.out.println(e.getKey() + ":");
			for (String s: e.getValue()) {
				//System.out.println(String.format("  %s", s));
			}
		}
		
		List<Weapon> filtered = new ArrayList<Weapon>();
		WeaponAdditionalInfoFactory waif = WeaponAdditionalInfoFactory.getInstance();
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		filtered = wf.getWeaponsByRequirements(awq);
		
		List<Weapon> adv_filtered = new ArrayList<Weapon>();
		if (awq.getWeapon_type().equalsIgnoreCase("heavy-bowgun") || awq.getWeapon_type().equalsIgnoreCase("light-bowgun")) {
			for (Weapon w: filtered) {
				AmmoInfo info = waif.getAmmoInfoByName(w.getName());
				if (info == null) continue;
				List<Map<String, String>> bowgun_reqs = awq.getBowgun_reqs();
				boolean qualified = info.meetRequirements(bowgun_reqs);
				if (qualified) adv_filtered.add(w);
			}
		}else {
			adv_filtered.addAll(filtered);
		}

		for (Weapon w: adv_filtered) {
			String img_path;
			if (w.getCategory() != null) {
				img_path = "kt.png";
			}else {
				img_path = waif.getWeaponImagePath(w.getName());
				if (img_path == null) {
					String default_name = awq.getWeapon_type() + "-default.png";
					img_path = waif.getWeaponImagePath(default_name);
				}
			}
			//System.out.println(w.getName() + ", " + img_path);
			w.setImage_path(img_path);
		}
		
		mv.addObject("weapons", adv_filtered);
		mv.addObject("weapon_type", awq.getWeapon_type());
		return mv;
		
	}
	
	/**
	@RequestMapping(value="/WeaponFinder/results", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Weapon getQueriedWeapons(@RequestBody Map<String, String> query, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("WeaponPage");
		String weapon_type = "";
		String element = "";
		Integer affinity = 0;
		Integer num_slots = 0;
		String additional = "";
		
		if (query.containsKey("weapon_type")) {
			weapon_type = query.get("weapon_type");
		}
		if (query.containsKey("element")) {
			element = query.get("element");
		}
		if (query.containsKey("affinity")) {
			String aff_str = query.get("affinity");
			affinity = aff_str.equals("--")? -100 : Integer.parseInt(aff_str);
		}
		if (query.containsKey("num_slots")) {
			num_slots = Integer.parseInt(query.get("num_slots"));
		}
		if (query.containsKey("additional")) {
			additional = query.get("additional");
		}
		
		AdvancedWeaponQuery awq = new AdvancedWeaponQuery(weapon_type, element, affinity, num_slots);
		if (!additional.isEmpty()) awq.setAdditional(additional);
		
		if (query.containsKey("bowgun_reqs")) {
			List<Map<String, Object>> req_list = new ArrayList<Map<String, Object>>();
			String req_str = query.get("bowgun_reqs");
			String[] reqs = req_str.split("&");
			for (String req : reqs) {
				Map<String, Object> req_map = new HashMap<String, Object>();
				String[] entries = req.split(";");
				for (String entry : entries) {
					String[] pair = entry.trim().split(":");
					req_map.put(pair[0].trim(), pair[1].trim());
				}
				req_list.add(req_map);
			}
			
			awq.setBowgun_reqs(req_list);
		}
		
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		List<Weapon> filtered = wf.getWeaponsByType("great-sword", TOP);
		System.out.println(filtered.size());
		System.out.println(awq);
		if (!filtered.isEmpty()) {
			return filtered.get(0);
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/WeaponFinder/results", method=RequestMethod.POST)
	public ModelAndView getQueriedWeapons(@ModelAttribute("query") WeaponQuery wq, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("WeaponPage");
		String additional_info = (String)request.getParameter("additional_info");
		
		if (result.hasErrors()) {
			for (ObjectError e : result.getAllErrors()) {
				System.err.println(e);
			}
			return mv;
		}else {
			System.out.println(wq);
			wq.setAdditional_info(additional_info);
			WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
			WeaponAdditionalInfoFactory waif = WeaponAdditionalInfoFactory.getInstance();
			List<Weapon> filtered = wf.getWeaponsByRequirements(wq);
			for (Weapon w: filtered) {
				String img_path;
				if (w.getCategory() != null) {
					img_path = "kt.png";
				}else {
					img_path = waif.getWeaponImagePath(w.getName());
					if (img_path == null) {
						String default_name = wq.getWeapon_type() + "-default.png";
						img_path = waif.getWeaponImagePath(default_name);
					}
				}
				System.out.println(w.getName() + ", " + img_path);
				w.setImage_path(img_path);
			}
			mv.addObject("weapons", filtered);
			mv.addObject("weapon_type", wq.getWeapon_type());
			return mv;
		}
	}**/
}
