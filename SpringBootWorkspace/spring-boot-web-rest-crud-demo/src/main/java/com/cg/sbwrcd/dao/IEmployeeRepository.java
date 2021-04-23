package com.cg.sbwrcd.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sbwrcd.entity.Department;
import com.cg.sbwrcd.entity.Employee;
import com.cg.sbwrcd.exception.EmployeeException;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByMobile(String mobile) throws EmployeeException;
	boolean existsByEmail(String email) throws EmployeeException;
	
	Employee findByMobile(String mobile);
	Employee findByEmail(String email);
	
	List<Employee> findAllByDeptName(Department dept);
	List<Employee> findAllByJoinDate(LocalDate joinDate);
	List<Employee> findAllByBasicSalaryBetween(BigInteger lb, BigInteger ub);
}
