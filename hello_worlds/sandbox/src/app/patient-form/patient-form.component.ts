import { Component, OnInit } from '@angular/core';
import {PatientService} from "../patient.service";
import {Patient} from "./Patient";

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
  surname : string;
  text: string = "Patienten";
  patient = {};

  patients: Patient[];
  private selectedPatient: Patient;

  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.getPatients();
  }

  getPatients(){
    this.patientService.getPatients().subscribe(data => this.patients = data);
  }
/*
  loadPatientAdd(){
    this.patientService.addPatient(this.value1, this.value2).subscribe(data => this.patient = data);
    this.getPatients();
    location.reload();
  }
*/
  findPatientGet(){
    this.patientService.getPatient(this.id).subscribe(data => this.patient = data);
  }

  findPatientBySurname(){
    this.patientService.getPatientbySurname(this.surname).subscribe(data => this.patient = data);
  }

  removePatient(id){
    this.patientService.removePatient(id).subscribe(data => this.patient = data);
    this.getPatients();
    location.reload();
  }

  onSelect(patient: Patient){
    this.selectedPatient = patient;
  }
}
