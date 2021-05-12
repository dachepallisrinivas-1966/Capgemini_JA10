import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  imageUrl : string;

  constructor() { 
    this.imageUrl = "./assets/flower-1.jpg";
  }

  ngOnInit(): void {
  }
  

}
