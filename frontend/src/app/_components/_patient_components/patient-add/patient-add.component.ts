import { Component, OnInit } from '@angular/core';
import {Patient} from "../../../_classes/Patient";
import {PatientService} from "../../../_services/patient.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-patient-add',
  templateUrl: './patient-add.component.html',
  styleUrls: ['./patient-add.component.css']
})
export class PatientAddComponent implements OnInit {

  infos: any = {};
  loading = false;
  patient: Patient;

  constructor(private patientService: PatientService, private router: Router) {
  }

  ngOnInit() {
  }


  addPatient() {
    this.patient.update(null, this.infos.firstname, this.infos.surname, this.infos.email, null);
    this.patientService.addPatient(this.patient);
    this.router.navigateByUrl("/patient");
  }







}
