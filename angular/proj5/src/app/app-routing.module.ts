import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpFormComponent } from './emp-form/emp-form.component';

const routes: Routes = [
  { path : 'dashboard', component : DashboardComponent },
  { path : 'emps', component : EmployeeComponent, children : [
      { path : 'list', component : EmpListComponent },
      { path : 'add', component : EmpFormComponent },
      { path : 'edit/:eid', component : EmpFormComponent },
      { path : '', redirectTo : 'list', pathMatch : 'full'}
  ] },
//   { path : 'assets', component : AssetComponent, children : [
//     { path : 'list', component : AssetListComponent },
//     { path : 'add', component : AssetFormComponent },
//     { path : 'edit/:aid', component : AssetFormComponent },
//     { path : '', redirectTo : 'list', pathMatch : 'full'}
// ] },
  { path : '', redirectTo : 'dashboard' , pathMatch : 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
