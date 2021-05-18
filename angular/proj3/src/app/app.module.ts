import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoanFormComponent } from './loan-form/loan-form.component';

import { ReactiveFormsModule } from '@angular/forms';
import { EmpFormComponent } from './emp-form/emp-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoanFormComponent,
    EmpFormComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
