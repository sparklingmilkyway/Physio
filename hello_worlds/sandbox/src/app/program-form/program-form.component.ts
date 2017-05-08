import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-program-form',
  templateUrl: './program-form.component.html',
  styleUrls: ['./program-form.component.css']
})
export class ProgramFormComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  text: string = "Programme";
}

