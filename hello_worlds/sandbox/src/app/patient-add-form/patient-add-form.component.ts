import { Component, OnInit } from '@angular/core';
import {PatientService} from "../patient.service";
import {Patient} from "../patient-form/Patient";

@Component({
  selector: 'app-patient-add-form',
  templateUrl: './patient-add-form.component.html',
  styleUrls: ['./patient-add-form.component.css']
})
export class PatientAddFormComponent implements OnInit {

  surname : string;
  lastname : string;
  patient = {};
  patients: Patient[];

  constructor(private patientService: PatientService) { }

  ngOnInit() {
  }

  loadPatientAdd(){
    this.patientService.addPatient(this.surname, this.lastname).subscribe(data => this.patient = data);
    this.getPatients();
    location.reload();
  }

  getPatients(){
    this.patientService.getPatients().subscribe(data => this.patients = data);
  }
}
