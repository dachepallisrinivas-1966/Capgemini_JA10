import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structural',
  templateUrl: './structural.component.html',
  styleUrls: ['./structural.component.css']
})
export class StructuralComponent implements OnInit {
  bookTitle : string;
  books : string [];
  count : number;

  constructor() { 
    this.bookTitle = "";
    // this.books = ["The Monk Who Sold His Ferari", "Great Escape", "Treasure Hunt"];
    this.books = [];
    this.count = this.books.length;
  }

  ngOnInit(): void {
  }

  addBook() : void {
    this.books.push(this.bookTitle);
    this.count = this.books.length;
  }

}
