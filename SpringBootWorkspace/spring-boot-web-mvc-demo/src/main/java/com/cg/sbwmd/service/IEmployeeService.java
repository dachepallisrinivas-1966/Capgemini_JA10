package com.cg.sbwmd.service;

import com.cg.sbwmd.model.Employee;

@FunctionalInterface
public interface IEmployeeService {
	void computeAllowances(Employee e);
}
