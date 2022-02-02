import {Component, OnInit} from '@angular/core';
import {ServService} from "./sevicio/serv.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  usuario = PersonModel;

  constructor(public serv: ServService) {
  }

  ngOnInit() {
    this.serv.getall().subscribe(data => {
      this.usuario = data;
      console.log("asdsad")
    });
  }

}
