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
    var patientToUpdate = this.patient;
    patientToUpdate.update(this.patient.id, this.patient.firstname,this.patient.surname,this.patient.email, this.patient.therapeut);
    this.patientService.changePatient(patientToUpdate).subscribe(data => this.patient = data);
    location.reload();
  }
}
