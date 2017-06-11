import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import {Patient} from "../../_classes/Patient";
import {PatientService} from "../../_services/patient.service";
import {Popup} from 'ng2-opd-popup';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [PatientService]

})
export class AddComponent implements OnInit {

  /*
  @ViewChild('popup1') popup1: Popup;
  @ViewChild('popup2') popup2: Popup;
  @ViewChild('popup3') popup3: Popup;

  value1:string = "Vorname";
  value2:string = "Nachname";
  id:number;
  surname : string;
  text: string = "Patienten";
  patient = {};
  patients: Patient[];
  private selectedPatient: Patient;
  */


  constructor(private patientService: PatientService, private router:Router /*, private popup: Popup*/) { }

  ngOnInit() {
    this.router.navigateByUrl('/add/overview');
  }



  /*
  clickPatientAdd(){
    this.popup1.options = {
      header: "Patient hinzufügen ",
      color: "#B2D3DE", // red, blue....
      widthProsentage: 40, // The with of the popou measured by browser width
      animationDuration: 0.5, // in seconds, 0 = no animation
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Hinzufügen", // The text on your confirm button
      cancleBtnContent: "Abbrechen", // the text on your cancel button
      confirmBtnClass: "btn btn-default", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };
    this.popup2.hide();
    this.popup3.hide();
    this.popup1.show(this.popup1.options);
  }


  clickExerciseAdd(){
    this.popup2.options = {
      header: "Übung erstellen ",
      color: "#B2D3DE", // red, blue....
      widthProsentage: 40, // The with of the popou measured by browser width
      animationDuration: 0.5, // in seconds, 0 = no animation
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Erstellen", // The text on your confirm button
      cancleBtnContent: "Abbrechen", // the text on your cancel button
      confirmBtnClass: "btn btn-default", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };
    this.popup1.hide();
    this.popup3.hide();
    this.popup2.show(this.popup2.options);
  }

  clickProgrammAdd(){
    this.popup3.options = {
      header: "Programm erstellen ",
      color: "#B2D3DE", // red, blue....
      widthProsentage: 40, // The with of the popou measured by browser width
      animationDuration: 0.5, // in seconds, 0 = no animation
      showButtons: true, // You can hide this in case you want to use custom buttons
      confirmBtnContent: "Erstellen", // The text on your confirm button
      cancleBtnContent: "Abbrechen", // the text on your cancel button
      confirmBtnClass: "btn btn-default", // your class for styling the confirm button
      cancleBtnClass: "btn btn-default", // you class for styling the cancel button
      animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    };
    this.popup2.hide();
    this.popup1.hide();
    this.popup3.show(this.popup3.options);
  }

 */

}
