import { Component } from '@angular/core';
import {PraxisService} from "../praxis.service";


@Component({
  selector: 'app-welcome-form',

  templateUrl: './welcome-form.component.html',
  styleUrls: ['./welcome-form.component.css'],

/*
  template: `
    <div>
      <button (click)="loadPraxis()">Load praxis</button>
      {{ praxis | json }}
    </div>
  `
  */
})
export class WelcomeFormComponent {
  text: string = "Home";


  constructor(private praxisService: PraxisService) {}
  praxis = {};

  loadPraxis() {
    this.praxisService.getPraxis().subscribe(data => this.praxis = data);
   }


}
