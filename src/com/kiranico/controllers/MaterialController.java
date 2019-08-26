package com.kiranico.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiranico.backend.MaterialFactory;

@Controller
public class MaterialController {
	@RequestMapping(value="/Material/{material_name}", method=RequestMethod.GET)
	public ModelAndView getMaterial(@PathVariable(value="material_name") String material_name) {
		ModelAndView view = new ModelAndView("MaterialPage");
		MaterialFactory fact = MaterialFactory.getMaterialFactoryInstance();
		System.out.println(String.format("mat = %s", material_name));
		fact.getMaterialLocations(material_name);
		view.addObject("name", material_name);
		return view;
	}
}
