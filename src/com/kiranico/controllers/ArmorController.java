package com.kiranico.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.ArmorFactory;
import com.kiranico.backend.WeaponAdditionalInfoFactory;
import com.kiranico.entities.Armor;
import com.kiranico.entities.Armorset;
import com.kiranico.misc.ArmorQuery;

@Controller
public class ArmorController {

	@RequestMapping(value="/Armors", method=RequestMethod.GET)
	public ModelAndView getAllArmors() {
		ModelAndView mv = new ModelAndView("allArmorsets");
		ArmorFactory af = ArmorFactory.getInstance();
		List<Armorset> all_armorsets = af.getAllArmorsets();
		WeaponAdditionalInfoFactory waif = WeaponAdditionalInfoFactory.getInstance();
		if (!all_armorsets.isEmpty()) {
			for (Armorset as: all_armorsets) {
				if (as.getImg_path() == null) {
					String path = waif.getArmorsetImageByName(as.getName());
					as.setImg_path(path);
				}
				//System.out.println(as.getSkillsDescription());
			}
		}
		mv.addObject("armorsets", all_armorsets);
		return mv;
	}
	
	@RequestMapping(value="/Armorset/{name}", method=RequestMethod.GET)
	public ModelAndView getArmorset(@PathVariable(value="name") String name) {
		ModelAndView mv = new ModelAndView("singleArmorset");
		ArmorFactory af = ArmorFactory.getInstance();
		Armorset selected = af.getSingleArmorset(name);
		if (selected != null) {
			Map<String, Object> attr_map = selected.getAttributeMap();
			for (Map.Entry<String, Object> e: attr_map.entrySet()) {
				//System.out.println(e.getKey() + ", " + e.getValue());
			}
			Map<String, Armor> pieces = selected.getPieces();
			mv.addObject("pieces", pieces);
			mv.addAllObjects(attr_map);
		}
		return mv;
	}
	
	@RequestMapping(value="/ArmorFinder", method=RequestMethod.GET)
	public ModelAndView getArmorFinder() {
		ModelAndView mv = new ModelAndView("ArmorFinder");
		return mv;
	}
	
	@RequestMapping(value="/ArmorFinder/results", method=RequestMethod.POST)
	public @ResponseBody List<Armor> getArmorFinderResults(@RequestBody Map<String, String> query) {
		if (!query.isEmpty()) {
			ArmorFactory af = ArmorFactory.getInstance();
			List<Armor> armors = af.getAllArmors();
			List<Armor> qualified = new ArrayList<Armor>();
			Integer sl1 = query.get("slot_1").equals("--")? 0 : Integer.parseInt(query.get("slot_1"));
			Integer sl2 = query.get("slot_2").equals("--")? 0 : Integer.parseInt(query.get("slot_2"));
			Integer sl3 = query.get("slot_2").equals("--")? 0 : Integer.parseInt(query.get("slot_3"));
			String sk1 = query.get("skill_1");
			String sk2 = query.get("skill_2");
			ArmorQuery aq = new ArmorQuery(sl1, sl2, sl3, sk1, sk2);
			for (Armor a: armors) {
				if (a.meetRequirement(aq)) qualified.add(a);
			}
			System.out.println(qualified.size());
			return qualified;
		}
		return null;
	}
	
	@RequestMapping(value="/ArmorFinder/getAllSkills", method=RequestMethod.GET)
	public @ResponseBody List<String> getAllSkills(){
		ArmorFactory af = ArmorFactory.getInstance();
		List<String> all_skills = af.getAllSkills();
		return all_skills;
	}
}
