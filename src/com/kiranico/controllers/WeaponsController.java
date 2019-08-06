package com.kiranico.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.WeaponAdditionalInfoFactory;
import com.kiranico.backend.WeaponFactory;
import com.kiranico.entities.AmmoInfo;
import com.kiranico.entities.Melody;
import com.kiranico.entities.Weapon;

@Controller
@SuppressWarnings("unused")
public class WeaponsController {
	private static final String weapon_img_dir = "/../WebContent/WEB-INF/imgs/weapons";
	private final int ALL = 0;
	private final int TOP = 1;
	private final int BOTTOM = 2;
	
	@RequestMapping(value="/Weapon/{weapon_type}", method=RequestMethod.GET)
	public ModelAndView getWeapons(@PathVariable(value="weapon_type") String weapon_type) {
		ModelAndView view = new ModelAndView("WeaponPage");
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		
		List<Weapon> selected_weapons = wf.getWeaponsByType(weapon_type, TOP);
		//System.out.println(String.format("Got %d results", selected_weapons.size()));
		
		view.addObject("weapons", selected_weapons);
		view.addObject("weapon_type", weapon_type);
		return view;
	}
	
	@RequestMapping(value="/Weapon/{weapon_type}/{weapon_name}", method=RequestMethod.GET)
	public ModelAndView getWeapon(@PathVariable(value="weapon_type") String weapon_type, @PathVariable(value="weapon_name") String weapon_name) {
		ModelAndView view = new ModelAndView("SingleWeapon");
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		Weapon target = wf.getWeapon(weapon_name);
		if (target != null) {
			HashMap<String, Object> weapon_attrs = target.getAttributesMap();
			List<Weapon> family = wf.getWeaponFamily(target.getName());
			weapon_attrs.put("family", family);
			view.addAllObjects(weapon_attrs);
			
			System.out.println(target.getWeapon_type());
			if (weapon_type.equals("hunting-horn")) {
				WeaponAdditionalInfoFactory hhnf = WeaponAdditionalInfoFactory.getInstance();
				List<Melody> melodies = hhnf.getMelodiesByName(target.getName());
				
				//System.out.println(String.format("-------- %s [%s] --------", target.getName(), target.getNotes()));
				//for (Melody m : melodies) {
				//	System.out.println(m + " ");
				//}
				
				view.addObject("melodies", melodies);
			}else if (weapon_type.equals("light-bowgun") || weapon_type.equals("heavy-bowgun")) {
				WeaponAdditionalInfoFactory fact = WeaponAdditionalInfoFactory.getInstance();
				AmmoInfo info = fact.getAmmoInfoByName(weapon_name);
				
			}
		}
		return view;
	}
	
	@RequestMapping(value="/Weapon/{weapon_type}/sort_by/{attr}", method=RequestMethod.GET)
	public ModelAndView getWeaponsSorted(@PathVariable(value="weapon_type") String weapon_type, @PathVariable(value="attr") String attr) {
		ModelAndView view = new ModelAndView("WeaponPage");
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		
		List<Weapon> current_displayed = wf.getCurrent_displayed();
		System.out.println("Sort by " + attr);
		Collections.sort(current_displayed, Weapon.getComparator(attr));
		view.addObject("weapons", current_displayed);
		view.addObject("weapon_type", weapon_type);
		wf.setCurrent_displayed(current_displayed);
		return view;
	}

}
