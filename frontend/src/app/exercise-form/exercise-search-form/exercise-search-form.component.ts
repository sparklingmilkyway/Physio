import { Component, OnInit } from '@angular/core';
import {ExerciseService} from "../exercise.service";
import {Exercise} from "../Exercise";

@Component({
  selector: 'app-exercise-search-form',
  templateUrl: './exercise-search-form.component.html',
  styleUrls: ['./exercise-search-form.component.css']
})
export class ExerciseSearchFormComponent implements OnInit {

  selectedExercise: Exercise;
  searchValue;
  exercise = {};

  constructor(private exerciseService: ExerciseService) { }

  onSelect(exercise: Exercise){
    this.selectedExercise = exercise;
  }

  // fehlt noch in Service!!! zurzeit nur mit ID suchen
  getExerciseById(){
    this.exerciseService.getExercise(this.searchValue).subscribe(data => this.exercise = data);
  }

  ngOnInit() {
  }

}
