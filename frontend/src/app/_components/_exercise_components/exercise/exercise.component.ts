import { Component, OnInit } from '@angular/core';
import {Exercise} from "../../../_classes/Exercise";
import {ExerciseService} from "../../../_services/exercise.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css'],
  providers: [ExerciseService]

})
export class ExerciseComponent implements OnInit {

  exercise = {};
  exercises: Exercise[];
  private selectedExercise: Exercise;

  constructor(private exerciseService: ExerciseService, private router: Router) { }

  ngOnInit( ) {
     this.getExercises();
  }

  goToExerciseDetails(id) {
    this.router.navigate(['/exercise', id]);
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

