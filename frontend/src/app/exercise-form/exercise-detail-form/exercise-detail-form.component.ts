import {Component, Input, OnInit} from '@angular/core';
import {Exercise} from "../Exercise";
import {ExerciseService} from "../exercise.service";

@Component({
  selector: 'app-exercise-detail-form',
  templateUrl: './exercise-detail-form.component.html',
  styleUrls: ['./exercise-detail-form.component.css']
})
export class ExerciseDetailFormComponent implements OnInit {
  @Input() exercise: Exercise;
  ID: number;
  exercises = {};

  constructor(private exerciseService: ExerciseService) { }

  ngOnInit() {
  }

  changeExercise(){
    var exerciseToUpdate = this.exercise;
    this.exercise.update(exerciseToUpdate.id, exerciseToUpdate.name, exerciseToUpdate.type, exerciseToUpdate.therapeut);
    this.exerciseService.changeExercise(exerciseToUpdate).subscribe(data => this.exercises);
    location.reload();
  }


}
