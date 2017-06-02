import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Patient} from "../../_classes/Patient";
import {PatientService} from "../../_services/patient.service";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [PatientService]

})
export class AddComponent implements OnInit {



  constructor(private patientService: PatientService, private router:Router) { }

  ngOnInit() {
  }




}
