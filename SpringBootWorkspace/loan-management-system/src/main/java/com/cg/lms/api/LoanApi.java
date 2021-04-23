package com.cg.lms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.exception.LoanException;
import com.cg.lms.model.LoanModel;
import com.cg.lms.service.ILoanService;

@RestController
@RequestMapping(path="/loans")
public class LoanApi {
	
	@Autowired
	private ILoanService loanService;
	
	@GetMapping
	public ResponseEntity<List<LoanModel>> findAll() {
		// return new ResponseEntity<>(loanService.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(loanService.findAll());
	}
	

	@GetMapping("/{loanId}")
	public ResponseEntity<LoanModel> findById(@PathVariable("loanId") Long loanId) {
		ResponseEntity<LoanModel> response = null;
		LoanModel loan = loanService.findById(loanId);
		
		if (loan == null) {
			// response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(loan);
		}
		return response;
	}
	
	@PostMapping
	public ResponseEntity<LoanModel> createEmployee(@RequestBody LoanModel loan) throws LoanException {
		loan = loanService.add(loan);
		return new ResponseEntity<>(loan, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{loanId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("loanId") Long loanId) throws LoanException{
		ResponseEntity<Void> response = null;
		LoanModel loan = loanService.findById(loanId);
		if (loan == null) {
			// response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			response = ResponseEntity.notFound().build();
		} else {
			loanService.deleteById(loanId);
			// response = new ResponseEntity<>(HttpStatus.OK);
			response = ResponseEntity.ok().build();
		}
		return response;
	}
	
	@PutMapping
	public ResponseEntity<LoanModel> updateLoan(@RequestBody LoanModel loan) throws LoanException {
		loan = loanService.save(loan);
		// return new ResponseEntity<>(emp, HttpStatus.OK);
		return ResponseEntity.ok(loan);
	}
	
	
}
