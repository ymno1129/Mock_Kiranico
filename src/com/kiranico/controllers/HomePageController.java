package com.kiranico.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	@RequestMapping("/index")
	public ModelAndView displayHomePage() {
		ModelAndView home = new ModelAndView("HomePage");
		int a = 1;
		return home;
	}
	
	@RequestMapping(value="/Test")
	public ModelAndView displayTestPage() {
		ModelAndView test = new ModelAndView("testHome");
		return test;
	}
	
	@RequestMapping(value="/Test_2")
	public ModelAndView displayTestPage2() {
		ModelAndView test = new ModelAndView("testCSS2");
		return test;
	}
	
	@RequestMapping(value="/Weapons")
	public ModelAndView displayWeaponsPage() {
		ModelAndView weapons = new ModelAndView("Weapons");
		return weapons;
	}
	
	
}
