import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ExerciseService} from "../../../_services/exercise.service";
import {Therapeut} from "../../../_classes/Therapeut";

@Component({
  selector: 'app-exercise-details',
  templateUrl: './exercise-details.component.html',
  styleUrls: ['./exercise-details.component.css'],
  providers: [ExerciseService]
})
export class ExerciseDetailsComponent implements OnInit {

  id: number;
  private sub: any;


  constructor(private route: ActivatedRoute, private exerciseService: ExerciseService, private router: Router) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];

      this.exerciseService.getExercise(this.id).subscribe(data => this.sub = data);

    });
  }

  goBack() {
    this.router.navigateByUrl('/exercise');
  }

  change() {
  }

}
