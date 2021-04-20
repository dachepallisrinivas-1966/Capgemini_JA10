package com.cg.sbwmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.sbwmd.service.IGreetService;

@Controller
public class GreetController {
	
	@Autowired
	@Qualifier(value = "gss")
	private IGreetService greetService;
	
	@GetMapping(path="/greet")
	public ModelAndView greetAction(@RequestParam(name="uname", required=false) String userName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("greet");
		if (userName != null) {
			mv.addObject("greetMessage", greetService.getMessage(userName));
		}
		return mv;
	}
}
