import { Component, OnInit } from '@angular/core';
import {PraxisService} from "app/praxis.service";
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private praxisService: PraxisService, public fb: FormBuilder) {
    doLogin(event)
    {
      console.log(event);
      console.log(this.addTherapeutForm.value);
    }
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



  public addTherapeutForm = this.fb.group({
    email: ["", Validators.required],
    password: ["", Validators.required]
  });
}
