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

  firstname: string;
  surname: string;
  email: string;

  constructor(private patientService: PatientService, private router: Router) {
  }

  ngOnInit() {
  }


  addPatient() {
    var patient = new Patient(null, this.firstname, this.surname, this.email, null);
    this.patientService.addPatient(patient);
    this.router.navigateByUrl("/patient");
  }
}
