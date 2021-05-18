import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoanService } from '../service/loan.service';

import { Loan } from '../model/loan';

@Component({
  selector: 'app-loan-form',
  templateUrl: './loan-form.component.html',
  styleUrls: ['./loan-form.component.css']
})
export class LoanFormComponent implements OnInit {

  pfc : FormControl;
  tfc : FormControl;
  rfc : FormControl;

  loanForm : FormGroup;
  
  @Output() loanSubmit : EventEmitter<Loan>;
  
  constructor(private loanService : LoanService) { 
    this.pfc = new FormControl(null, [Validators.required, Validators.min(1000), Validators.max(50000)]);  
    this.tfc = new FormControl(null, [Validators.required, Validators.min(1), Validators.max(10)]);
    this.rfc = new FormControl(null, [Validators.required, Validators.min(1), Validators.max(10)]);
    
    this.loanForm = new FormGroup({
      principle : this.pfc, 
      time : this.tfc,
      rate : this.rfc
    });

    this.loanSubmit = new EventEmitter();
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    let loan = this.loanService.compute(this.loanForm.value);
    
    this.loanSubmit.emit(loan);
  }
}
