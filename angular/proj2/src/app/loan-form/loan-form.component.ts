import { Component, OnInit } from '@angular/core';
import { Loan } from '../model/loan';
import { LoanService } from '../service/loan.service';

@Component({
  selector: 'app-loan-form',
  templateUrl: './loan-form.component.html',
  styleUrls: ['./loan-form.component.css']
})
export class LoanFormComponent implements OnInit {

  loan: Loan;

  constructor(private loanService: LoanService) {
    this.loan = {
      principle: null,
      time: null,
      rate: null,
      interest: null,
      amount: null
    };
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    let loan = this.loanService.compute(this.loan);
    //alert(JSON.stringify(loan));
  }

}
