package com.cg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries ({
	@NamedQuery(name="costly_employees", query = "SELECT e FROM Employee e WHERE e.salary >= :sal"),
	@NamedQuery(name="moderate_employees", query = "SELECT e FROM Employee e WHERE e.salary < :sal"),
})

@Entity
@Table(name="employees")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="employee_id")
	private Integer empId;
	
	@Column(name="first_name", length=20)
	private String firstName;
	
	@Column(name="last_name", length=25)
	private String lastName;
	
	@Column(name="salary")
	private Integer salary;
	
	@Column(name="department_id")
	private Integer deptId;
	
	public Employee() {
		/* no implementation required */
	}

	@Override
	public String toString() {
		return String.format("empId=%s, firstName=%s, lastName=%s, salary=%s, deptId=%s", empId, firstName,
				lastName, salary, deptId);
	}
	
}
