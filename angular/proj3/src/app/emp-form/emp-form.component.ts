import { Component, OnInit } from '@angular/core';
import { Emp } from '../model/emp';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EmpService } from '../service/emp.service';

@Component({
  selector: 'app-emp-form',
  templateUrl: './emp-form.component.html',
  styleUrls: ['./emp-form.component.css']
})
export class EmpFormComponent implements OnInit {

  emp : Emp
  
  namefc : FormControl;
  genderfc : FormControl;
  dateJoinedfc : FormControl;
  isMarriedfc : FormControl;
  qualificationfc : FormControl;
  basicSalaryfc : FormControl;

  empForm : FormGroup;

  constructor(private empService : EmpService) { 
    this.emp = {
      name : null,
      gender : null,
      dateJoined : null,
      isMarried : null,
      qualification : null,
      basicSalary : null,
      hra : null,
      ta : null,
      grossSalary : null
    };

    this.namefc = new FormControl(null, Validators.required);
    this.genderfc = new FormControl(null, Validators.required);
    this.dateJoinedfc = new FormControl(null, Validators.required);
    this.isMarriedfc = new FormControl(null, Validators.required);
    this.qualificationfc = new FormControl(null, Validators.required);
    this.basicSalaryfc = new FormControl(null, 
      [Validators.required, Validators.min(1000), Validators.max(50000)]);
    
    this.empForm = new FormGroup({
      name : this.namefc,
      gender : this.genderfc,
      dateJoined : this.dateJoinedfc,
      isMarried : this.isMarriedfc,
      qualification : this.qualificationfc,
      basicSalary : this.basicSalaryfc
    });

  }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.emp = this.empService.compute(this.emp);
  }

}
