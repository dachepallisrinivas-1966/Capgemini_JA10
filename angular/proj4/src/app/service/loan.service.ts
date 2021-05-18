import { Injectable } from '@angular/core';
import { Loan } from '../model/loan';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  
  constructor() { }

  compute(loan : Loan) : Loan {
    loan.interest = loan.principle*loan.time*loan.rate/100;
    loan.amount = loan.principle + loan.interest;
    return loan;
  }
}
