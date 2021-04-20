package com.cg.sbwmd.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Employee {
	private long empId;
	private String empName;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfJoin;
	private double basic;
	private double hra;
	private double ta;
	private String designation;
	
	public Employee() {
		/* no implementation required */
	}

	public Employee(long empId, String empName, LocalDate dateOfJoin, double basic, double hra, double ta,
			String designation) {
		this.empId = empId;
		this.empName = empName;
		this.dateOfJoin = dateOfJoin;
		this.basic = basic;
		this.hra = hra;
		this.ta = ta;
		this.designation = designation;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return String.format("empId=%s, empName=%s, dateOfJoin=%s, basic=%s, hra=%s, ta=%s, designation=%s",
				empId, empName, dateOfJoin, basic, hra, ta, designation);
	}
	
	
	
	
}
