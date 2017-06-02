import { Component, OnInit } from '@angular/core';
import {ExerciseService} from "../../exercise-form/exercise.service";
import {Exercise} from "../../exercise-form/Exercise";

@Component({
  selector: 'app-program-create-form',
  templateUrl: './program-create-form.component.html',
  styleUrls: ['./program-create-form.component.css']
})
export class ProgramCreateFormComponent implements OnInit {

  exercises: Exercise[];
  addedExercises: Array<Exercise> = [];

  constructor(private exerciseService: ExerciseService) {

  }

  ngOnInit() {
  }

  getExercises(){
    this.exerciseService.getExercises().subscribe( data => this.exercises = data);
  }

  addToProgramm(exercise: Exercise){
    this.addedExercises.push(exercise);
  }
}
