package com.cg.sbwmd.service;

import org.springframework.stereotype.Service;

import com.cg.sbwmd.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public void computeAllowances(Employee e) {
		e.setHra(e.getBasic()*0.8);
		e.setTa(e.getBasic()*0.1);
	}

}
