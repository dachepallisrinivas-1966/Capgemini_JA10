import { Component, OnInit, Input } from '@angular/core';
import { Loan } from '../model/loan';

@Component({
  selector: 'app-loan-view',
  templateUrl: './loan-view.component.html',
  styleUrls: ['./loan-view.component.css']
})
export class LoanViewComponent implements OnInit {

  @Input() loan : Loan;
  
  constructor() { }

  ngOnInit(): void {
  }

}
