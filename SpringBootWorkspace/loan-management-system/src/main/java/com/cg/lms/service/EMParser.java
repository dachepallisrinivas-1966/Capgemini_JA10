package com.cg.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.ILoanRepository;
import com.cg.lms.entity.LoanEntity;
import com.cg.lms.model.LoanModel;

@Service
public class EMParser {

	@Autowired
	private ILoanRepository loanRepo;
	
	public LoanModel parse(LoanEntity source) {
		return source==null ? null:
			new LoanModel(source.getLoanId(),
					source.getApplicantName(),
					source.getPrinciple(),
					source.getLoanDisbursementDate(),
					source.getLoanCloseDate(),
					source.getTimeInMonths(),
					source.getRate(),
					source.getEmi()
					);
	}
	
	public LoanEntity parse(LoanModel source) {
		return source==null ? null:
			new LoanEntity(source.getLoanId(),
					source.getApplicantName(),
					source.getPrinciple(),
					source.getLoanDisbursementDate(),
					source.getLoanCloseDate(),
					source.getTimeInMonths(),
					source.getRate(),
					source.getEmi()
					);
	}

}
