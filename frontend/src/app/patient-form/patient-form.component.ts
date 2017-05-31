import {Component, OnInit, ViewChild} from '@angular/core';
import {PatientService} from "../patient.service";
import {Patient} from "./Patient";
import {Popup} from 'ng2-opd-popup';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css'],
  providers: [PatientService]
})

export class PatientFormComponent implements OnInit {

  @ViewChild('popup1') popup1: Popup;

  value1:string = "Vorname";
  value2:string = "Nachname";
  id:number;
  surname : string;
  text: string = "Patienten";
  patient = {};
  patients: Patient[];
  private selectedPatient: Patient;

  constructor(private patientService: PatientService, private popup: Popup) { }

  ngOnInit() {
    this.getPatients();
  }

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
  }

  getPatients(){
    //this.patientService.getPatients().subscribe(data => this.patients = data);
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

  changePatient(){
    this.patientService.changePatient(this.selectedPatient.id,this.selectedPatient.therapeut,this.selectedPatient.surname,this.selectedPatient.firstname,this.selectedPatient.email).subscribe(data => this.patient = data);
    location.reload();
  }

}
