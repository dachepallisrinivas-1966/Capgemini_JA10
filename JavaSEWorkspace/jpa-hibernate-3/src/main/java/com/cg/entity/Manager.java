package com.cg.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//single table strategy
//@Entity
//@DiscriminatorValue(value = "M")

// joined strategy
//@Entity
//@Table(name="mgr2")

// TABLE PER CLASS strategy
@Entity
@Table(name="mgr3")
public class Manager extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="bonus")
	private BigInteger bonus;
	
	public Manager() {
		/* no implementation */
	}

	public Manager(Long empId, String empName,  BigInteger bonus) {
		super(empId, empName);
		this.bonus = bonus;
	}

	public BigInteger getBonus() {
		return bonus;
	}

	public void setBonus(BigInteger bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return String.format("bonus=%s, getEmpId()=%s, getEmpName()=%s", getBonus(), getEmpId(),
				getEmpName());
	}
}
