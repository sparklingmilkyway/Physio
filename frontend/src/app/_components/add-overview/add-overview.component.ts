import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-overview',
  templateUrl: './add-overview.component.html',
  styleUrls: ['./add-overview.component.css']
})
export class AddOverviewComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  clickPatientAdd(){
    this.router.navigateByUrl('/add/patientadd');
  }

  clickExerciseAdd(){
    this.router.navigateByUrl('/add/exerciseadd');
  }

  clickProgrammAdd(){
    this.router.navigateByUrl('/add/programmadd');
  }


}
