import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  emps: Employee[];
  err: string;

  constructor(private empsService: EmployeeService) { }

  ngOnInit(): void {
    this.empsService.getAll().subscribe(
      (data) => this.emps = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }

  delete(empId: number) {
    if (confirm("Are you sure?")) {
      this.empsService.deleteById(empId).subscribe(
        () => { this.emps.splice(this.emps.findIndex(e => e.empId == empId), 1) }
      );
    }
  }

}
