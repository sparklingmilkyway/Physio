import { Component, OnInit } from '@angular/core';
import {PatientService} from "../../../_services/patient.service";
import {Patient} from "../../../_classes/Patient";

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css'],
  providers: [PatientService]

})
export class PatientComponent implements OnInit {

  //@ViewChild('popup1') popup1: Popup;

  value1:string = "Vorname";
  value2:string = "Nachname";
  id:number;
  firstname: string;
  surname : string;
  patient = {};
  patients: Patient[];
  private selectedPatient: Patient;

  constructor(private patientService: PatientService/*, private popup: Popup*/) { }

  ngOnInit() {
    this.getPatients();
  }


  getPatients(){
    this.patientService.getPatients().subscribe(data => this.patients = data);
  }


  removePatient(id){
    this.patientService.removePatient(id).subscribe(data => this.patient = data);
    this.getPatients();
    location.reload();
  }

  onSelect(patient: Patient){
    this.selectedPatient = patient;
  }

  changePatient(){
    this.patientService.changePatient(this.selectedPatient).subscribe(data => this.patient = data);
    location.reload();
  }


  /*
   clickButton(){


   this.popup1.options = {
   header: "Details für Patient "+this.selectedPatient.firstname,
   color: "lightblue", // red, blue....
   widthProsentage: 40, // The with of the popou measured by browser width
   animationDuration: 0.5, // in seconds, 0 = no animation
   showButtons: true, // You can hide this in case you want to use custom buttons
   confirmBtnContent: "Änderungen speichern", // The text on your confirm button
   cancleBtnContent: "Abbrechen", // the text on your cancel button
   confirmBtnClass: "btn btn-default", // your class for styling the confirm button
   cancleBtnClass: "btn btn-default", // you class for styling the cancel button
   animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
   };
   this.popup1.show(this.popup1.options);
   } */

  /*
   findPatientGet(){
   this.patientService.getPatient(this.id).subscribe(data => this.patient = data);
   }

   findPatientBySurname(){
   this.patientService.getPatientbySurname(this.surname).subscribe(data => this.patient = data);
   }

   */

}
