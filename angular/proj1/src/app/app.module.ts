import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { StructuralComponent } from './structural/structural.component';
import { PipeComponent } from './pipe/pipe.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    StructuralComponent,
    PipeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
