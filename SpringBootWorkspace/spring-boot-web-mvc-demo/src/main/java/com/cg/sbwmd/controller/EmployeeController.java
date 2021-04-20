package com.cg.sbwmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.sbwmd.model.Employee;
import com.cg.sbwmd.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path="/emp")
	public ModelAndView employeeInputAction() {
		return new ModelAndView("emp-input", "emp", new Employee());
	}
	
	@PostMapping(path="/emp")
	public ModelAndView employeeOutputAction(@ModelAttribute(name = "emp") Employee employee) {
		employeeService.computeAllowances(employee);
		return new ModelAndView("emp-output", "emp", employee);
	}
	
	@ModelAttribute
	public void populateDesignations(Model model) {
		model.addAttribute("designations", new String[] { "Clerk", "Manager", "Sales Person", "Vice President"});
	}
	
}
