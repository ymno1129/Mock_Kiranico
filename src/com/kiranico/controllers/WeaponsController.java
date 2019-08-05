package com.kiranico.controllers;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.MaterialFactory;
import com.kiranico.backend.WeaponFactory;
import com.kiranico.entities.Weapon;

@Controller
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
		MaterialFactory mf = MaterialFactory.getMaterialFactoryInstance();
		Weapon target = wf.getWeapon(weapon_name);
		if (target != null) {
			
			//Construct "slots"
			int[] slots = {target.getSlot_1(), target.getSlot_2(), target.getSlot_3()};
			StringBuilder slotString = new StringBuilder();
			for (int i = 0; i < slots.length; i ++) {
				if (slots[i] == 0) {
					slotString.append("-"); 
				}else {
					slotString.append(Integer.toString(slots[i]));
				}
			}
			//Construct "element"
			StringBuilder elementString = new StringBuilder();
			boolean isHidden = target.getElement_hidden();
			String ele1 = target.getElement1();
			Integer ele1_atk = target.getElement1_atk();
			if (ele1_atk == null) {
				elementString.append("-");
			}else {
				elementString.append(Integer.toString(ele1_atk));
				elementString.append(" ");
				elementString.append(ele1.toLowerCase());
			}
			if (isHidden) elementString.append("\n(hidden)");
			
			List<Weapon> family = wf.getWeaponFamily(weapon_name);
			HashMap<String, Integer> materials = target.getMaterials();
			
			for (Map.Entry<String, Integer> entry : materials.entrySet()) {
			    String key = entry.getKey();
			    Integer value = entry.getValue();
			    System.out.println(String.format("%d %s", value, key));
			}
			
			StringBuilder weapon_img_path = new StringBuilder();
			String curr_dir = Paths.get("").toAbsolutePath().toString();
			String img_filename = weapon_name + ".png";
			img_filename = "buster_sword.png";
			weapon_img_path.append(curr_dir);
			weapon_img_path.append("\\");
			//weapon_img_path.append(weapon_img_dir);
			weapon_img_path.append(img_filename);
			String img_path = weapon_img_path.toString();
			//System.out.println(img_path);
			//System.out.println(new File(img_path).exists());
			
			view.addObject("name", target.getName());
			view.addObject("attack", target.getAttack());
			view.addObject("element", elementString.toString());
			view.addObject("affinity", Integer.toString(target.getAffinity()) + "%");
			view.addObject("slots", slotString.toString());
			view.addObject("rarity", target.getRarity());
			view.addObject("family", family);
			view.addObject("materials", materials);
			view.addObject("weapon_type", weapon_type);
			view.addObject("img_path", weapon_img_path.toString());
			
			
		}
		
		view.addObject("name", weapon_name);
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
