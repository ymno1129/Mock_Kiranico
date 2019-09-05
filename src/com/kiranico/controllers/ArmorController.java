package com.kiranico.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.ArmorFactory;
import com.kiranico.backend.WeaponAdditionalInfoFactory;
import com.kiranico.entities.Armorset;

@Controller
public class ArmorController {

	@RequestMapping(value="/Armors", method=RequestMethod.GET)
	public ModelAndView getAllArmors() {
		ModelAndView mv = new ModelAndView("allArmorsets");
		ArmorFactory af = ArmorFactory.getInstance();
		//List<Armor> all_armors = af.getAllArmors();
		List<Armorset> all_armorsets = af.getAllArmorsets();
		WeaponAdditionalInfoFactory waif = WeaponAdditionalInfoFactory.getInstance();
		if (!all_armorsets.isEmpty()) {
			for (Armorset as: all_armorsets) {
				if (as.getImg_path() == null) {
					String path = waif.getArmorsetImageByName(as.getName());
					as.setImg_path(path);
				}
				System.out.println(as.getName() + ", " + as.getImg_path());
			}
		}
		mv.addObject("armorsets", all_armorsets);
		return mv;
	}
	
	@RequestMapping(value="/Armorset/{name}", method=RequestMethod.GET)
	public ModelAndView getArmorset(@PathVariable(value="name") String name) {
		ModelAndView mv = new ModelAndView("singleArmorset");
		return mv;
	}
}
