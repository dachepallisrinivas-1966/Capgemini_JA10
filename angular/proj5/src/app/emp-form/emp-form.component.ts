import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-emp-form',
  templateUrl: './emp-form.component.html',
  styleUrls: ['./emp-form.component.css']
})
export class EmpFormComponent implements OnInit {
    empIdfc : FormControl;
    fullNamefc : FormControl;
    basicSalaryfc : FormControl;
    joinDatefc : FormControl;
    deptNamefc : FormControl;
    mobilefc : FormControl;
    emailfc : FormControl;

    empForm : FormGroup;

    depts : string[];

    isEditing : boolean;

  constructor(private empsService : EmployeeService, private router : Router,
    private activatedRoute : ActivatedRoute) { 

    // this.empIdfc = new FormControl(null, Validators.required);
    this.empIdfc = new FormControl(null);
    this.fullNamefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.basicSalaryfc = new FormControl(null, [Validators.required, Validators.min(1000), Validators.max(50000)]);
    this.joinDatefc = new FormControl(null, Validators.required);
    this.deptNamefc = new FormControl('SALES');
    this.mobilefc = new FormControl(null, [Validators.required, Validators.pattern("[1-9][0-9]{9}")]);
    this.emailfc = new FormControl(null, Validators.required);

    this.empForm = new FormGroup({
      empId : this.empIdfc,
      fullName : this.fullNamefc,
      basicSalary : this.basicSalaryfc,
      joinDate : this.joinDatefc,
      deptName : this.deptNamefc,
      mobile : this.mobilefc,
      email : this.emailfc
    });

    this.depts = ["SALES", "ACCOUNTS", "MARKETING", "IT", "PRODUCTION"]
    this.isEditing = false;
  }

  ngOnInit(): void {
    let eid = this.activatedRoute.snapshot.params.eid;
    if (eid) {
      this.isEditing = true;
      this.empsService.getById(eid).subscribe(
        (data) => this.empForm.setValue(data)
      );
    }
  } 

  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.empsService.update(this.empForm.value);
    } else {
      obr = this.empsService.add(this.empForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/emps")
    );
  }



}
