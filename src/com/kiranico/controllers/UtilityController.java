package com.kiranico.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.WeaponAdditionalInfoFactory;
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
	}
}
