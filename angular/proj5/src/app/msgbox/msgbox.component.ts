import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-msgbox',
  templateUrl: './msgbox.component.html',
  styleUrls: ['./msgbox.component.css']
})
export class MsgboxComponent implements OnInit {

  @Input() isError : boolean;
  
  constructor() { }

  ngOnInit(): void {
  }

}
