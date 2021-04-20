package com.cg.sbwcd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sbwcd.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
