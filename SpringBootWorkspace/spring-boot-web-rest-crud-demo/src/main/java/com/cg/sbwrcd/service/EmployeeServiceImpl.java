package com.cg.sbwrcd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sbwrcd.dao.IEmployeeRepository;
import com.cg.sbwrcd.entity.Department;
import com.cg.sbwrcd.entity.Employee;
import com.cg.sbwrcd.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Employee add(Employee emp) throws EmployeeException {
		
		if (emp != null) {
			if (empRepo.existsById(emp.getEmpId())) {
				throw new EmployeeException("Employee with Id " + emp.getEmpId() + " is exist already");
			} else if (empRepo.existsByMobile(emp.getMobile())) {
				throw new EmployeeException("Employee with mobile number " + emp.getMobile() + " is exist already");
			} else if (empRepo.existsByEmail(emp.getEmail())) {
				throw new EmployeeException("Employee with email " + emp.getEmail() + " is exist already");
			} else {
				emp = empRepo.save(emp);
			}
		}
		return emp;
	}

	@Override
	public Employee save(Employee emp) throws EmployeeException {
		Employee oldEmp = empRepo.findById(emp.getEmpId()).orElse(null);
	
		if (oldEmp == null) {
			throw new EmployeeException("No Employee with id " + emp.getEmpId() + " is present");
		} else if (!oldEmp.getMobile().equals(emp.getMobile()) && empRepo.existsByMobile(emp.getMobile())) {
			throw new EmployeeException("Employee with mobile number " + emp.getMobile() + " is present");
		} else if (!oldEmp.getEmail().equals(emp.getEmail()) && empRepo.existsByEmail(emp.getEmail())) {
			throw new EmployeeException("Employee with email " + emp.getEmail() + " is present");
		} else {
			emp = empRepo.save(emp);
		}
		return emp;
	}

	@Override
	public void deleteById(long empId) {
		empRepo.deleteById(empId);

	}

	@Override
	public Employee findById(long empId) {
		return empRepo.findById(empId).orElse(null);
	}

	@Override
	public Employee findByMobile(String mobile) {
		return empRepo.findByMobile(mobile);
	}

	@Override
	public Employee findByEmail(String email) {
		return empRepo.findByEmail(email);
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public List<Employee> findAllByDeptName(Department dept) {
		return empRepo.findAllByDeptName(dept);
	}

	@Override
	public List<Employee> findAllByJoinDate(LocalDate joinDate) {
		return empRepo.findAllByJoinDate(joinDate);
	}

	@Override
	public List<Employee> findAllByBasicSalaryRange(int lb, int ub) {
		return empRepo.findAllByBasicSalaryRange(lb, ub);
	}

}
