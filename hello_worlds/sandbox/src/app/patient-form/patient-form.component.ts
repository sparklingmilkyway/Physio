import { Component, OnInit } from '@angular/core';
import {PatientService} from "../patient.service";

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css'],
  providers: [PatientService]
})

export class PatientFormComponent implements OnInit {

  value1:string = "Vorname";
  value2:string = "Nachname";
  id:number;


  constructor(private patientService: PatientService) { }

  ngOnInit() {
  }

  text: string = "Patienten";

  patient = {};

  loadPatientAdd(){
    this.patientService.addPatient(this.value1, this.value2).subscribe(data => this.patient = data);
  }

  findPatientGet(){
    this.patientService.getPatient(this.id).subscribe(data => this.patient = data);
  }

}
