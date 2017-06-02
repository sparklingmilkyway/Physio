import { Component, OnInit } from '@angular/core';
import {Exercise} from "../../../_classes/Exercise";
import {ExerciseService} from "../../../_services/exercise.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-exercise-add',
  templateUrl: './exercise-add.component.html',
  styleUrls: ['./exercise-add.component.css'],
  providers: [ExerciseService]
})
export class ExerciseAddComponent implements OnInit {

  id: number;
  name: string;
  type: string;
  therapeut: number;
  private exercise: Exercise;

  constructor(private exerciseService: ExerciseService, private router: Router) { }

  ngOnInit() {
  }

  addExercise(){
    this.exercise = new Exercise(null, this.name, this.type, null);
    this.exerciseService.addExercise(this.exercise).subscribe(data => this.exercise = data );
    this.router.navigateByUrl("/exercise");
  }

}
