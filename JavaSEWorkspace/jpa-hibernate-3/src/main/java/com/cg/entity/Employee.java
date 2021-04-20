package com.cg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

// Single Table Strategy
//@Entity
//@Table(name="all_employees")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.CHAR)
//@DiscriminatorValue(value = "E")

// Joined Strategy
//@Entity
//@Table(name="emps2")
//@Inheritance(strategy = InheritanceType.JOINED)

// Table PER CLASS strategy
@Entity
@Table(name="emps3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private Long empId;
	
	@Column(name="ename", length=30)
	private String empName;
	
	public Employee() {
		/* no implementation */
	}

	public Employee(Long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return String.format("empId=%s, empName=%s", empId, empName);
	}
	
	
}
