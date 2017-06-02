import { Component, OnInit } from '@angular/core';
import {Patient} from "../patient-form/Patient";
import {PatientService} from "../patient.service";
import {Exercise} from "app/exercise-form/Exercise";
import {ExerciseService} from "./exercise.service";

@Component({
  selector: 'app-exercise-form',
  templateUrl: './exercise-form.component.html',
  styleUrls: ['./exercise-form.component.css'],
  providers: [ExerciseService]
})

export class ExerciseFormComponent implements OnInit {

  text: string = "Übungen";
  exercise = {};
  exercises: Exercise[];
  private selectedExercise: Exercise;

  constructor(private exerciseService: ExerciseService) { }

  ngOnInit() {
    this.getExercises();
  }

  getExercises(){
    this.exerciseService.getExercises().subscribe( data => this.exercises = data);
  }

  removeExercise(id: number){
    this.exerciseService.removeExercise(id).subscribe(data => this.exercise = data);
    this.getExercises();
    location.reload();
  }

  onSelect(exercise: Exercise){
      this.selectedExercise = exercise;
  }
}
