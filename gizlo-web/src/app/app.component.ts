import {Component, OnInit} from '@angular/core';
import {ServService} from "./sevicio/serv.service";
import {Person} from "./model/person";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  persons: Person[] = [];

  constructor(public serv: ServService) {
  }

  ngOnInit() {
    this.serv.getAll().then(data => {
      this.persons = data
      console.log("users array ", this.persons);
    });
    /* this.serv.getAll().subscribe((response) => {
       this.persons = response.body;
       console.log("users array ", this.persons);
     });*/
  }

}
