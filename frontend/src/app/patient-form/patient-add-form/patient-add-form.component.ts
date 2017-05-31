import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../Patient";
import {PatientService} from "../../patient.service";


@Component({
  selector: 'app-patient-add-form',
  templateUrl: './patient-add-form.component.html'
})
export class PatientAddFormComponent implements OnInit {

  firstname : string;
  surname : string;
  email : string;
  patient = {};
  patients: Patient[]

  constructor(private patientService: PatientService) {
  }

  ngOnInit() {
  }

  loadPatientAdd(){
    var newPatient = new Patient(this.firstname, this.surname, this.email, null);
    this.patientService.addPatient(newPatient).subscribe(data => this.patient = data);
    this.getPatients();
    location.reload();
  }

  getPatients(){
    this.patientService.getPatients().subscribe(data => this.patients = data);
  }
}
