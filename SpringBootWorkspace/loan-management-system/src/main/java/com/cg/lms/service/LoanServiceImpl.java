package com.cg.lms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.ILoanRepository;
import com.cg.lms.entity.LoanEntity;
import com.cg.lms.exception.LoanException;
import com.cg.lms.model.LoanModel;

@Service
public class LoanServiceImpl implements ILoanService {

	@Autowired
	private ILoanRepository loanRepo;
	
	@Autowired
	private EMParser parser;
	
	@Override
	public LoanModel add(LoanModel loan) throws LoanException {
		if (loan != null) {
			if (loanRepo.existsById(loan.getLoanId())) {
				throw new LoanException("loan with #" + loan.getLoanId() + " is present already");
			} else {
				loan = parser.parse(loanRepo.save(parser.parse(loan)));
			}
		}
		return loan;
	}

	@Override
	public LoanModel save(LoanModel loan) throws LoanException {
		LoanEntity oldLoan = loanRepo.findById(loan.getLoanId()).orElse(null);
		if (oldLoan == null) {
			throw new LoanException("no loan with id #" + loan.getLoanId() + " present");
		} else {
			loan = parser.parse(loanRepo.save(parser.parse(loan)));
		}
		return loan;
	}

	@Override
	public void deleteById(Long loanId) throws LoanException {
		LoanEntity oldLoan = loanRepo.findById(loanId).orElse(null);
		if (oldLoan == null) {
			throw new LoanException("no loan with id #" + loanId + " present");
		} else {
			loanRepo.deleteById(loanId);
		}
	}

	@Override
	public LoanModel findById(Long loanId) {
		return parser.parse(loanRepo.findById(loanId).orElse(null));
	}

	@Override
	public List<LoanModel> findAll() {
		// return loanRepo.findAll().stream().map(loan -> parser.parse(loan)).collect(Collectors.toList());
		return loanRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

}


