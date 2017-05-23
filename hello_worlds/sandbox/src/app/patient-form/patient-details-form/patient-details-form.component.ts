import {Component, Input, OnInit} from '@angular/core';
import {PatientService} from "../../patient.service";
import {Patient} from "../Patient";

@Component({
  selector: 'app-patient-details-form',
  templateUrl: './patient-details-form.component.html',
  styleUrls: ['./patient-details-form.component.css']
})
export class PatientDetailsFormComponent implements OnInit {
  @Input() patient: Patient;
  ID: number;
  patients = {};

  constructor(private patientService: PatientService) { }

  ngOnInit() {
  }

  findPatient(){
    this.patientService.getPatient(this.ID).subscribe(data => this.patient = data);
  }

  changePatient(){
    this.patientService.changePatient(this.patient.id,this.patient.therapeut,this.patient.surname,this.patient.lastname,this.patient.email).subscribe(data => this.patients = data);
  }
}
