import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  
  // template : `<h1>Welcome to angular</h1>
  //             <p>this is a paragraph</p>
  //             <div>this is div</div>`,
  
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : string;

  constructor() {
    this.title = "Welcome user !!";
  }

}
