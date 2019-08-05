package com.kiranico.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.WeaponFactory;
import com.kiranico.entities.Weapon;
import com.kiranico.misc.WeaponQuery;

@Controller
public class UtilityController {

	@RequestMapping(value="/WeaponFinder")
	public ModelAndView getWeaponFinder() {
		ModelAndView mv = new ModelAndView("WeaponFinder");
		return mv;
	}
	
	@RequestMapping(value="/WeaponFinder/results", method=RequestMethod.POST)
	public ModelAndView getQueriedWeapons(@ModelAttribute("query") WeaponQuery wq, BindingResult result) {
		ModelAndView mv = new ModelAndView("WeaponPage");
		
		if (result.hasErrors()) {
			for (ObjectError e : result.getAllErrors()) {
				System.err.println(e);
			}
			return mv;
		}else {
			//System.out.println(wq);
			WeaponFactory wf = WeaponFactory.getWeaponFactoryInstance();
			List<Weapon> filtered = wf.getWeaponsByRequirements(wq);
			mv.addObject("weapons", filtered);
			mv.addObject("weapon_type", wq.getWeapon_type());
			return mv;
		}
	}
}
