import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AssetComponent } from './asset/asset.component';
import { HeaderComponent } from './header/header.component';
import { LoanComponent } from './loan/loan.component';
import { LoanFormComponent } from './loan-form/loan-form.component';

import { ReactiveFormsModule } from '@angular/forms';
import { LoanViewComponent } from './loan-view/loan-view.component';

@NgModule({
  declarations: [
    AppComponent,
    AssetComponent,
    HeaderComponent,
    LoanComponent,
    LoanFormComponent,
    LoanViewComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
