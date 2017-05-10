import { Component, OnInit } from '@angular/core';
import {PraxisService} from "app/praxis.service";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private praxisService: PraxisService) {

  }

  praxis = {};

  therapeutsAdd = {};

  therapeuts = {};


  ngOnInit() {
  }

  loadPraxisAdd() {
    this.praxisService.addPraxis().subscribe(data => this.praxis = data);
  }

  loadTherapeutsAdd() {
    this.praxisService.addTherapeuts().subscribe(data => this.therapeutsAdd = data);
  }

  loadTherapeuts() {
    this.praxisService.getTherapeuts().subscribe(data => this.therapeuts = data);
  }

  loadAddTherapeutForm() {

  }
}
