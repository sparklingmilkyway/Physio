import {Injectable, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';
import {Patient} from "./patient-form/Patient";

/**
 * this is a so called service from the Angular framework. the goal is ti have exactly one injectable instance who makes
 * calls to our server. these uri calls are static. If we have enough time, we will change the directory of this file directly into the patient
 * form component.
 **/

 @Injectable()
export class PatientService implements OnInit{

  private baseUrl : string;

  ngOnInit(){

  }

  constructor(private http: Http) {
    this.baseUrl = "http://127.0.0.1:8080/api/patient";
  }


  // POST METHODS
  addPatient(patient : Patient) {
    return this.http.post(this.baseUrl, patient).map((res:Response) => res.json());
  }

  changePatient(patient: Patient){
    return this.http.post(this.baseUrl+'/update', patient).map((res:Response) => res.json());
  }



  // GET METHODS

  getPatient(id){
    return this.http.get(this.baseUrl+"/"+id).map((res:Response) => res.json());
  }

  getPatientbySurname(surname: string){
    return this.http.get(this.baseUrl+`/sn=`+surname).map((res:Response) => res.json());
  }

  getPatients(){
    return this.http.get(this.baseUrl).map((res:Response) => res.json());
  }


  // REQUEST METHODS

  removePatient(id){
    return this.http.request(this.baseUrl+`/remove/`+id).map((res:Response) => res.json());
  }


}
