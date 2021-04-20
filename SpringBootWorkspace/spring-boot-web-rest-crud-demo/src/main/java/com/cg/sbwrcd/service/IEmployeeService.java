package com.cg.sbwrcd.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.sbwrcd.entity.Department;
import com.cg.sbwrcd.entity.Employee;
import com.cg.sbwrcd.exception.EmployeeException;

public interface IEmployeeService {

	Employee add(Employee emp) throws EmployeeException;
	Employee save(Employee emp) throws EmployeeException;
	void deleteById(long empId);
	
	Employee findById(long empId);
	Employee findByMobile(String mobile);
	Employee findByEmail(String email);
	
	List<Employee> findAll();
	List<Employee> findAllByDeptName(Department dept);
	List<Employee> findAllByJoinDate(LocalDate joinDate);
	List<Employee> findAllByBasicSalaryRange(int lb, int ub);
	
}
