package com.cg.sbwcd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.sbwcd.entity.Department;
import com.cg.sbwcd.entity.Employee;
import com.cg.sbwcd.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	/* used to display messages */
	public final static int SAVED = 1;
	public final static int DELETED = 2;
	
	@Autowired
	private IEmployeeService empService;
	
	/* to bind departments enumeration values to drop down control in ui*/
	@ModelAttribute
	public void populateCommonData(Model model) {
		model.addAttribute("depts", Department.values());
	}
	
	@GetMapping(path = "/emps")
	public ModelAndView empListAction() {
		return new ModelAndView("emp-list", "emps", empService.findAll());
	}
	
	@GetMapping(path="/newEmp")
	public ModelAndView newEmpAction() {
		return new ModelAndView("emp-form", "emp", new Employee());
	}
	
	@PostMapping(path="/newEmp")
	public ModelAndView saveEmpAction(@Valid @ModelAttribute("emp") Employee emp, BindingResult results) {
		ModelAndView mv;
		if (results.hasErrors()) {
			mv = new ModelAndView("emp-form", "emp", emp);
		} else {
			emp = empService.save(emp);
			long empId = emp.getEmpId();
			mv = new ModelAndView("redirect:/home?id="+empId+"&msgCode="+SAVED);
		}
		return mv;
	}
	
	
	
	
}
