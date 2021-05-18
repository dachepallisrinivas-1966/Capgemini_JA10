import { Component, OnInit } from '@angular/core';
import { Loan } from '../model/loan';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { LoanService } from '../service/loan.service';

@Component({
  selector: 'app-loan-form',
  templateUrl: './loan-form.component.html',
  styleUrls: ['./loan-form.component.css']
})
export class LoanFormComponent implements OnInit {

  loan: Loan;

  pfc: FormControl;
  tfc: FormControl;
  rfc: FormControl;

  loanForm: FormGroup;

  constructor(private loanService : LoanService) {
    this.loan = {
      principle: null,
      time: null,
      rate: null,
      interest: null,
      amount: null
    };

    this.pfc = new FormControl('0', 
      [Validators.required, Validators.min(1000), Validators.max(50000)]);
    this.tfc = new FormControl('0', 
      [Validators.required, Validators.min(1), Validators.max(50)]);
    this.rfc = new FormControl('0', 
      [Validators.required, Validators.min(1), Validators.max(10)]);

    this.loanForm = new FormGroup({
      principle : this.pfc,
      time : this.tfc,
      rate : this.rfc
    });
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.loan = this.loanService.compute(this.loanForm.value);
  }

}
