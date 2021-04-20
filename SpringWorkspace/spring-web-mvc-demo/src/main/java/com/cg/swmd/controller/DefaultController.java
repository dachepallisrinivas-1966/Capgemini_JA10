package com.cg.swmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
//	@RequestMapping(path = "/")
//	public String greet() {
//		return "index";			// index is logical view name, finds "/pages/index.jsp
//	}
	
	@RequestMapping(path = "/")
	public ModelAndView defaultAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home"); 			// look for /pages/home.jsp 
		
		mv.addObject("companyName", "CapGemini India");
		mv.addObject("phones", new String[] {"040-815630", "045-815631", "080-815632", "081-815633"});
		
		return mv;
	}
}
