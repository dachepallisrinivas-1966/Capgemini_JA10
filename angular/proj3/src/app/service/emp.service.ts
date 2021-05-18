import { Injectable } from '@angular/core';
import { Emp } from '../model/emp';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor() { }

  compute(emp : Emp) : Emp {
    emp.hra = emp.basicSalary*0.8;
    emp.ta = emp.basicSalary*0.1;
    emp.grossSalary = emp.basicSalary + emp.hra + emp.ta;
    return emp;
  }
}
