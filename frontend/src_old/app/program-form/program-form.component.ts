import { Component, OnInit } from '@angular/core';
import {ExerciseService} from "../exercise-form/exercise.service";
import {Exercise} from "../exercise-form/Exercise";

@Component({
  selector: 'app-program-form',
  templateUrl: './program-form.component.html',
  styleUrls: ['./program-form.component.css'],
  providers: [ExerciseService]
})
export class ProgramFormComponent implements OnInit {



  constructor() {}

  ngOnInit() {

  }


}

