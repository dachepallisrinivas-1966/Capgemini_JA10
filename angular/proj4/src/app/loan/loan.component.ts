import { Component, OnInit } from '@angular/core';
import { Loan } from '../model/loan';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {
  loan: Loan;

  constructor() {
    this.loan = {
      principle: null,
      time: null,
      rate: null,
      interest: null,
      amount: null
    }
  }

  ngOnInit(): void {
  }

  handleLoanSubmit(loan: Loan) {
    this.loan = loan;
  }

}
