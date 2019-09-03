package com.kiranico.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.ArmorFactory;
import com.kiranico.entities.Armor;

@Controller
public class ArmorController {

	@RequestMapping(value="/Armors", method=RequestMethod.GET)
	public ModelAndView getAllArmors() {
		ModelAndView mv = new ModelAndView("allArmors");
		ArmorFactory af = ArmorFactory.getInstance();
		List<Armor> all_armors = af.getAllArmors();
		return mv;
	}
}
