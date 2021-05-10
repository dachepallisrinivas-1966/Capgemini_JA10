package com.cg.sbwrcd.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sbwrcd.entity.Employee;
import com.cg.sbwrcd.exception.EmployeeException;
import com.cg.sbwrcd.service.IEmployeeService;

@RestController
@RequestMapping(path = "/emps")
@CrossOrigin
public class EmployeeAPI {
	
	@Autowired
	private IEmployeeService employeeService;
	
	/*
	 * to retrieve all employees
	 * return : List<Employee>
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> findAllAction() {
		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
	}
	
	/*
	 * to retrieve an employee 
	 * return : Employee
	 * params : employee Id
	 */
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> findByIdAction(@PathVariable("empId") Long employeeId) {
		ResponseEntity<Employee> response = null;
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return response;
	}
	
	/*
	 * to add an employee 
	 * return : Employee
	 * params : employee object
	 */
	@PostMapping
	public ResponseEntity<Employee> createEmployeeAction(@RequestBody Employee emp) throws EmployeeException {
		emp = employeeService.add(emp);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	
	/*
	 * to delete an employee 
	 * return : void
	 * params : employee Id
	 */
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteByIdAction(@PathVariable("empId") Long employeeId) {
		ResponseEntity<Void> response = null;
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			employeeService.deleteById(employeeId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	/*
	 * to modify an employee 
	 * return : Employee
	 * params : Employee
	 */
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) throws EmployeeException {
		emp = employeeService.save(emp);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
}
