import { Component, OnInit } from '@angular/core';
import {Patient} from "../../../_classes/Patient";
import {PatientService} from "../../../_services/patient.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-patient-add',
  templateUrl: './patient-add.component.html',
  styleUrls: ['./patient-add.component.css']
})
export class PatientAddComponent implements OnInit {

  model: any;
  firstname: string;
  surname: string;
  email: string;
  loading = false;

  constructor(private patientService: PatientService, private router: Router) {
  }

  ngOnInit() {
  }


  addPatient() {
    this.patientService.addPatient(new Patient(null, this.model.firstname, this.model.surname, this.model.email, null));
    this.router.navigateByUrl("/patient");
  }

}
