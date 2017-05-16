import { Component, OnInit } from '@angular/core';
import {PatientService} from "../patient.service";

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css'],
  providers: [PatientService]
})
export class PatientFormComponent implements OnInit {

  constructor(private patientService: PatientService) { }

  ngOnInit() {
  }

  text: string = "Patienten";

  patient = {};

  loadPatientAdd(){
    this.patientService.addPatient().subscribe(data => this.patient = data);
  }

}
