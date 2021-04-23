package com.cg.lms.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loans")
public class LoanEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_id")
	private Long loanId;
	
	@Column(name="applicant_name", length=20)
	private String applicantName;
	
	@Column(name="principle")
	private Double principle;
	
	@Column(name="disburse_date")
	private LocalDate loanDisbursementDate;
	
	@Column(name="closing_date")
	private LocalDate loanCloseDate;
	
	@Column(name="time_in_months")
	private Integer timeInMonths;
	
	@Column(name="rate")
	private Double rate;
	
	@Column(name="emi")
	private Double emi;
	
	public LoanEntity() {
		/* default constructor */
	}

	public LoanEntity(Long loanId, String applicantName, Double principle, LocalDate loanDisbursementDate, LocalDate loanCloseDate,
			Integer timeInMonths, Double rate, Double emi) {
		super();
		this.loanId = loanId;
		this.applicantName = applicantName;
		this.principle = principle;
		this.loanDisbursementDate = loanDisbursementDate;
		this.loanCloseDate = loanCloseDate;
		this.timeInMonths = timeInMonths;
		this.rate = rate;
		this.emi = emi;
	}

	public Long getLoanId() {
		return loanId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Double getPrinciple() {
		return principle;
	}

	public void setPrinciple(Double principle) {
		this.principle = principle;
	}

	public LocalDate getLoanDisbursementDate() {
		return loanDisbursementDate;
	}

	public void setLoanDisbursementDate(LocalDate loanDisbursementDate) {
		this.loanDisbursementDate = loanDisbursementDate;
	}

	public LocalDate getLoanCloseDate() {
		return loanCloseDate;
	}

	public void setLoanCloseDate(LocalDate loanCloseDate) {
		this.loanCloseDate = loanCloseDate;
	}

	public Integer getTimeInMonths() {
		return timeInMonths;
	}

	public void setTimeInMonths(Integer timeInMonths) {
		this.timeInMonths = timeInMonths;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

}
