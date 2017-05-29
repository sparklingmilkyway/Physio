import { Component, OnInit } from '@angular/core';
import {Patient} from "../Patient";
import {PatientService} from "../../patient.service";


@Component({
  selector: 'app-patient-add-form',
  templateUrl: './patient-add-form.component.html'
})
export class PatientAddFormComponent implements OnInit {

  surname : string;
  lastname : string;
  email : string;
  patient = {};
  patients: Patient[];

  constructor(private patientService: PatientService) {
  }

  ngOnInit() {
  }

  loadPatientAdd(){
    this.patientService.addPatientNew(this.surname, this.lastname,this.email).subscribe(data => this.patient = data);
    this.getPatients();
    location.reload();
  }

  getPatients(){
    this.patientService.getPatients().subscribe(data => this.patients = data);
  }
}
