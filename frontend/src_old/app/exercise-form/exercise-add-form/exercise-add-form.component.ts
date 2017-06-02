import { Component, OnInit } from '@angular/core';
import {ExerciseService} from "../exercise.service";
import {Exercise} from "../Exercise";

@Component({
  selector: 'app-exercise-add-form',
  templateUrl: './exercise-add-form.component.html',
  styleUrls: ['./exercise-add-form.component.css']
})
export class ExerciseAddFormComponent implements OnInit {

  name: string;
  gruppe: string;
  therapeut: number;
  exercise = {};
  exercises: Exercise[];

  constructor(private exerciseService: ExerciseService) { }

  ngOnInit() {
  }

  loadExerciseAdd(){
    this.exerciseService.addExercise(this.name,this.gruppe,this.therapeut).subscribe(data => this.exercise = data );
    this.getExercises();
    location.reload();
  }

  getExercises(){
    this.exerciseService.getExercises().subscribe( data => this.exercises = data);
  }

}
