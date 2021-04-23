package com.cg.lms.model;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class LoanModel {
	
	@NotNull(message="loan id cannot be null")
	private long loanId;
	
	@NotEmpty(message="applicant name cannot be empty")
	@NotNull(message="applicant name cannot be omitted")
	private String applicantName;
	
	@Min(value=1000,message="minimum principle amount is 1000")
	@Max(value=50000,message="maximum principle amount is 50000")
	private double principle;
	
	@DateTimeFormat(iso=ISO.DATE)
	@PastOrPresent(message="disbursement date cannot be future date")
	private LocalDate loanDisbursementDate;
	
	@DateTimeFormat(iso=ISO.DATE)
	@FutureOrPresent(message="close date cannot be future date")
	private LocalDate loanCloseDate;
	
	@Min(value=3, message="minimum time must be 3 months")
	@Max(value=60, message="maximum time must be 60 months")
	private int timeInMonths;
	
	@Min(value=6, message="minimum rate is 6%")
	@Max(value=36, message="maximum rate is 36%")
	private double rate;
	
	private double emi;
	
	public LoanModel() {
		/* default constructor */
	}

	public LoanModel(long loanId, String applicantName, double principle, LocalDate loanDisbursementDate,
			LocalDate loanCloseDate, int timeInMonths, double rate, double emi) {
		this.loanId = loanId;
		this.applicantName = applicantName;
		this.principle = principle;
		this.loanDisbursementDate = loanDisbursementDate;
		this.loanCloseDate = loanCloseDate;
		this.timeInMonths = timeInMonths;
		this.rate = rate;
		this.emi = emi;
	}

	public long getLoanId() {
		return loanId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
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

	public int getTimeInMonths() {
		return timeInMonths;
	}

	public void setTimeInMonths(int timeInMonths) {
		this.timeInMonths = timeInMonths;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicantName == null) ? 0 : applicantName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanCloseDate == null) ? 0 : loanCloseDate.hashCode());
		result = prime * result + ((loanDisbursementDate == null) ? 0 : loanDisbursementDate.hashCode());
		result = prime * result + (int) (loanId ^ (loanId >>> 32));
		temp = Double.doubleToLongBits(principle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + timeInMonths;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanModel other = (LoanModel) obj;
		if (applicantName == null) {
			if (other.applicantName != null)
				return false;
		} else if (!applicantName.equals(other.applicantName))
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (loanCloseDate == null) {
			if (other.loanCloseDate != null)
				return false;
		} else if (!loanCloseDate.equals(other.loanCloseDate))
			return false;
		if (loanDisbursementDate == null) {
			if (other.loanDisbursementDate != null)
				return false;
		} else if (!loanDisbursementDate.equals(other.loanDisbursementDate))
			return false;
		if (loanId != other.loanId)
			return false;
		if (Double.doubleToLongBits(principle) != Double.doubleToLongBits(other.principle))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (timeInMonths != other.timeInMonths)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"LoanModel [loanId=%s, applicantName=%s, principle=%s, loanDisbursementDate=%s, loanCloseDate=%s, timeInMonths=%s, rate=%s, emi=%s]",
				loanId, applicantName, principle, loanDisbursementDate, loanCloseDate, timeInMonths, rate, emi);
	}

	
}
