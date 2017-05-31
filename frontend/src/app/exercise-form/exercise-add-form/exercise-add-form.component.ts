import { Component, OnInit } from '@angular/core';
import {ExerciseService} from "../exercise.service";
import {Exercise} from "../Exercise";
import {Therapeut} from "../../Therapeut";

@Component({
  selector: 'app-exercise-add-form',
  templateUrl: './exercise-add-form.component.html',
  styleUrls: ['./exercise-add-form.component.css']
})
export class ExerciseAddFormComponent implements OnInit {

  name: string;
  gruppe: string;
  therapeut: Therapeut;
  exercise = {};
  exercises: Exercise[];

  constructor(private exerciseService: ExerciseService) { }

  ngOnInit() {
  }

  loadExerciseAdd(){
    var newExercise = new Exercise(this.name,this.gruppe,this.therapeut)
    this.exerciseService.addExercise(newExercise).subscribe(data => this.exercise = data );
    this.getExercises();
    location.reload();
  }

  getExercises(){
    this.exerciseService.getExercises().subscribe( data => this.exercises = data);
  }

}
