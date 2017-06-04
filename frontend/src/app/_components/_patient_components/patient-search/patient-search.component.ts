import { Component, OnInit } from '@angular/core';
import {Patient} from "../../../_classes/Patient";
import {PatientService} from "../../../_services/patient.service";

@Component({
  selector: 'app-patient-search',
  templateUrl: './patient-search.component.html',
  styleUrls: ['./patient-search.component.css']
})
export class PatientSearchComponent implements OnInit {

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
