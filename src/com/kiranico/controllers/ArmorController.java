package com.kiranico.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.ArmorFactory;
import com.kiranico.backend.WeaponAdditionalInfoFactory;
import com.kiranico.entities.Armor;
import com.kiranico.entities.Armorset;

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
}
