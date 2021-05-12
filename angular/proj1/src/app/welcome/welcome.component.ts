import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  imageUrl : string;
  title : string;
  userName : string;
  msg : string;
  currentClasses : object;
  brightRed : object;
  isBold : boolean;
  isItalic : boolean;
  paraContent : string;

  constructor() { 
    this.imageUrl = "./assets/flower-1.jpg";
    this.title = "Welcome Program";
    this.userName = "";
    this.msg = "";
    this.currentClasses = {"special" : true, "big" : true};
    this.brightRed = {"color" : "red", "font-size" : "30pt"};
    this.isBold = false;
    this.isItalic = false;
    this.paraContent = "Be Honest";
  }

  ngOnInit(): void {
  }

  greetUser() : void {
    this.msg = "Welcome " +  this.userName + "!";
  }
  

}
