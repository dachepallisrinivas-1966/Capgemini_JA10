package com.cg.lms.service;

import java.util.List;

import com.cg.lms.exception.LoanException;
import com.cg.lms.model.LoanModel;

public interface ILoanService {
	LoanModel add(LoanModel loan) throws LoanException;
	LoanModel save(LoanModel loan) throws LoanException;
	void deleteById(Long loanId) throws LoanException;
	
	LoanModel findById(Long loanId);
	List<LoanModel> findAll();
}
