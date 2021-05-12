import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css']
})
export class PipeComponent implements OnInit {
  numData : number;
  stringData : string;
  dateData : Date;
  percentData : number;
  months : string[];
  jsonData : object;

  constructor() { 
    this.numData = 123.4567;
    this.stringData = "our life is controlled by BELIEVES & VALUES";
    this.dateData = new Date();
    this.percentData = 0.95;
    this.months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug',
      'Sep', 'Oct', 'Nov', 'Dec'];
    this.jsonData = {"name" : "Srinivas Dachepalli", "age" : "54", "email" : "dachepallisrinivas@gmail.com"};
  }

  ngOnInit(): void {
  }

}
