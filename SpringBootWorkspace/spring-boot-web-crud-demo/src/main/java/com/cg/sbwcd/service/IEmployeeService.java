package com.cg.sbwcd.service;

import java.util.List;

import com.cg.sbwcd.entity.Employee;

public interface IEmployeeService {
	Employee save(Employee employee);
	void deleteById(Long empId);
	Employee findById(Long empId);
	List<Employee> findAll();
}
