package com.cg.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// single table strategy
//@Entity
//@DiscriminatorValue(value = "C")

// joined strategy
//@Entity
//@Table(name="cemp2")

// TABLE PER CLASS
@Entity
@Table(name="cemp3")
public class ContractEmployee extends Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="pay_rate")
	private BigInteger payRate;
	
	public ContractEmployee() {
		/* no implementation */
	}

	public ContractEmployee(Long empId, String empName, BigInteger payRate) {
		super(empId, empName);
		this.payRate = payRate;
	}

	public BigInteger getPayRate() {
		return payRate;
	}

	public void setPayRate(BigInteger payRate) {
		this.payRate = payRate;
	}

	@Override
	public String toString() {
		return String.format("payRate=%s, getEmpId()=%s, getEmpName()=%s", payRate, getEmpId(),
				getEmpName());
	}
}
