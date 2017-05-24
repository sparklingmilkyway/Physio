import { Component, OnInit } from '@angular/core';
import {PatientService} from "../../patient.service";
import {Patient} from "../Patient";

@Component({
  selector: 'app-patient-manipulate-form',
  templateUrl: './patient-manipulate-form.component.html',
  styleUrls: ['./patient-manipulate-form.component.css']
})
export class PatientManipulateFormComponent implements OnInit {

  searchValue;
  patient: {};
  selectedPatient: Patient;

  constructor(private patientService: PatientService) { }

  getPatientById(){
    this.patientService.getPatient(this.searchValue).subscribe(data => this.patient = data);
  }

  ngOnInit() {
  }

  onSelect(patient: Patient){
    this.selectedPatient = patient;
  }

}
