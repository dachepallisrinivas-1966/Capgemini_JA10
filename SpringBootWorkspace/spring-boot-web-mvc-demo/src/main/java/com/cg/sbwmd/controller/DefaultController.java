package com.cg.sbwmd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@Value("${organization.title}")				// SpEL - Spring Expression Language
	private String organizationTitle;
	
//	@GetMapping(path = "/home")
//	public String greet() {
//		return "home";
//	}
	

	@RequestMapping(path = "/header")	
	public ModelAndView headerAction() {
		return new ModelAndView("header", "ot", organizationTitle);
	}
	
	@GetMapping(path = "/home")
	public ModelAndView homeAction() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("name", "Srinivas Dachepalli");
		mv.addObject("age", 55);
		mv.addObject("location", "Visakhapatnam");
		mv.addObject("technologies", new String[] { "Java", "Angular", "React", "Oracle", "Postgre" });
		return mv;
	}
	
	@RequestMapping(path = "/footer")
	public ModelAndView footerAction() {
		return new ModelAndView("footer", "cr", "All rights are reserved - 2021");
	}
}
