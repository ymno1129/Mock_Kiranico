package com.kiranico.controllers;

import java.util.ArrayList;
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
import com.kiranico.misc.AmmoInfoSingle;

@Controller
@SuppressWarnings("unused")
public class WeaponsController {
	private static final String weapon_img_dir = "/../WebContent/WEB-INF/imgs/weapons";
	private final int ALL = 0;
	private final int TOP = 1;
	private final int BOTTOM = 2;
	
	/**
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
	}**/
	
	/**
	@RequestMapping(value="/Weapon/{weapon_type}/{weapon_name}", method=RequestMethod.GET)
	public ModelAndView getWeapon(@PathVariable(value="weapon_type") String weapon_type, @PathVariable(value="weapon_name") String weapon_name) {
		ModelAndView view = new ModelAndView("SingleWeapon");
		
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		Weapon target = wf.getWeapon(weapon_name);
		if (target != null) {
			HashMap<String, Object> weapon_attrs = target.getAttributesMap();
			
			//Get the corresponding weapon tree of this particular weapon
			List<Weapon> family = wf.getWeaponFamily(target.getName());
			weapon_attrs.put("family", family);
			view.addAllObjects(weapon_attrs);
			
			//Get sharpness image
			String[] words = weapon_name.split(" ");
			List<String> lower_words = new ArrayList<String>();
			for (String w: words) {
				lower_words.add(w.toLowerCase());
			}
			String sharpness_img_name = String.join("_", lower_words) + ".png";
			view.addObject("sharpness_img_name", sharpness_img_name);
			
			WeaponAdditionalInfoFactory fact = WeaponAdditionalInfoFactory.getInstance();
			String img_path = fact.getWeaponImagePath(weapon_name);
			if (img_path == null) {
				String default_name = weapon_type + "-default.png";
				img_path = fact.getWeaponImagePath(default_name);
			}
			view.addObject("weapon_image_name", img_path);
			
			if (weapon_type.equals("hunting-horn")) {
				List<Melody> melodies = fact.getMelodiesByName(target.getName());
				view.addObject("melodies", melodies);
			}else if (weapon_type.equals("light-bowgun") || weapon_type.equals("heavy-bowgun")) {
				AmmoInfo info = fact.getAmmoInfoByName(weapon_name);
				List<AmmoInfoSingle> ammo_info_list = info.getAmmoInfoLines();
				view.addObject("ammos", ammo_info_list);
			}else if (weapon_type.equals("gunlance")) {
				view.addObject("shelling_type", target.getShelling());
				String shelling_info = target.getShelling() + " Lv" + Integer.toString(target.getShelling_level());
				view.addObject("shelling_info", shelling_info);
			}else if (weapon_type.equals("insect-glaive")) {
				view.addObject("kinsect_bonus", target.getKinsect_bonus());
			}else if (weapon_type.equals("bow")) {
				
			}else if (weapon_type.equals("switch-axe")) {
				String phial_info = target.getPhial();
				if (target.getPhial_power() != null) phial_info = phial_info + "(" + target.getPhial_power() + ")";
				view.addObject("phial_info", phial_info);
			}else if (weapon_type.equals("charge-blade")) {
				view.addObject("cb_phial", target.getPhial());
			}
		}
		return view;
	}**/
	
	@RequestMapping(value="/Weapon/{weapon_type}", method=RequestMethod.GET)
	public ModelAndView getWeapons(@PathVariable(value="weapon_type") String weapon_type) {
		ModelAndView view = new ModelAndView("WeaponPage");
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		WeaponAdditionalInfoFactory fact = WeaponAdditionalInfoFactory.getInstance();
		
		List<Weapon> selected_weapons = wf.getWeaponsByType(weapon_type, TOP);
		
		for (Weapon w: selected_weapons) {
			String img_path;
			if (w.getCategory() != null) {
				img_path = "kt.png";
			}else {
				img_path = fact.getWeaponImagePath(w.getName());
				if (img_path == null) {
					String default_name = weapon_type + "-default.png";
					img_path = fact.getWeaponImagePath(default_name);
				}
			}
			
			w.setImage_path(img_path);
		}
		
		//System.out.println(String.format("Got %d results", selected_weapons.size()));
		
		view.addObject("weapons", selected_weapons);
		view.addObject("weapon_type", weapon_type);
		return view;
	}
	
	@RequestMapping(value="/Weapon/{weapon_type}/sort_by/{attr}", method=RequestMethod.GET)
	public ModelAndView getWeaponsSorted(@PathVariable(value="weapon_type") String weapon_type, @PathVariable(value="attr") String attr) {
		ModelAndView view = new ModelAndView("WeaponPage");
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		
		List<Weapon> current_displayed = wf.getCurrent_displayed();
		//System.out.println("Sort by " + attr);
		Collections.sort(current_displayed, Weapon.getComparator(attr));
		view.addObject("weapons", current_displayed);
		view.addObject("weapon_type", weapon_type);
		wf.setCurrent_displayed(current_displayed);
		return view;
	}

	@RequestMapping(value="/Weapon/{weapon_type}/{weapon_name}", method=RequestMethod.GET)
	public ModelAndView getWeapon(@PathVariable(value="weapon_type") String weapon_type, @PathVariable(value="weapon_name") String weapon_name) {
		ModelAndView view = new ModelAndView("SingleWeapon");
		view.addObject("weapon_name", weapon_name);
		view.addObject("weapon_type", weapon_type);
		WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
		Weapon target = wf.getWeapon(weapon_name);
		if (target != null) {
			WeaponAdditionalInfoFactory fact = WeaponAdditionalInfoFactory.getInstance();
			String img_path = fact.getWeaponImagePath(weapon_name);
			if (img_path == null) {
				String default_name = weapon_type + "-default.png";
				img_path = fact.getWeaponImagePath(default_name);
			}
			view.addObject("weapon_img_path", img_path);
			
			HashMap<String, Object> weapon_attrs = target.getNewAttributesMap();
			view.addAllObjects(weapon_attrs);
			
			List<Weapon> family = wf.getWeaponFamily(target.getName());
			for (Weapon p: family) {
				//There must be a better way to do this.
				//Don't want to make the "loadWeaponMaterials" method public since
				//it might cause unintended results when used in weird places.
				Weapon w = wf.getWeapon(p.getName());
				
				if (p.getImage_path() == null) {
					String path = fact.getWeaponImagePath(p.getName());
					if (path == null) {
						String default_name = weapon_type + "-default.png";
						path = fact.getWeaponImagePath(default_name);
					}
					p.setImage_path(path);
				}
			}
			view.addObject("family", family);
			
			//To be added
			if (weapon_type.equals("hunting-horn")) {
				List<Melody> melodies = fact.getMelodiesByName(target.getName());
				view.addObject("melodies", melodies);
				view.addObject("weapon_notes", target.getNotes());
			}else if (weapon_type.equals("light-bowgun") || weapon_type.equals("heavy-bowgun")) {
				AmmoInfo info = fact.getAmmoInfoByName(weapon_name);
				List<AmmoInfoSingle> ammo_info_list = info.getAmmoInfoLines();
				view.addObject("ammos", ammo_info_list);
			}else if (weapon_type.equals("gunlance")) {
				//view.addObject("shelling_type", target.getShelling());
				String shelling_info = target.getShelling() + " Lv" + Integer.toString(target.getShelling_level());
				view.addObject("shelling_info", shelling_info);
			}else if (weapon_type.equals("insect-glaive")) {
				view.addObject("kinsect_bonus", target.getKinsect_bonus());
			}else if (weapon_type.equals("bow")) {
				//TODO
			}else if (weapon_type.equals("switch-axe")) {
				String phial_info = target.getPhial();
				if (target.getPhial_power() != null) phial_info = phial_info + "(" + target.getPhial_power() + ")";
				view.addObject("phial_info", phial_info);
			}else if (weapon_type.equals("charge-blade")) {
				view.addObject("phial_info", target.getPhial());
			} 
		}
		int a = -1;
		return view;
	}
}
