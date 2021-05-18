import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  empsApi : string;  

  constructor(private httpClient : HttpClient) { 
    this.empsApi = "http://localhost:8082/emps";
  }

  getAll() : Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.empsApi);
  }

  getById(eid : number) : Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.empsApi}/${eid}`);
  }

  deleteById(eid : number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.empsApi}/${eid}`);
  }

  add(employee : Employee) : Observable<Employee> {
    return this.httpClient.post<Employee>(this.empsApi, employee);
  }

  update(employee : Employee) : Observable<Employee> {
    return this.httpClient.put<Employee>(this.empsApi, employee);
  }








  

}
