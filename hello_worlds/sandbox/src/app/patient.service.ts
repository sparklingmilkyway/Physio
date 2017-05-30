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

  patients: Patient[];
  ngOnInit(){

  }
  constructor(private http: Http) {
  }

  addPatient(surname : string, lastname : string){
    return this.http.request(`http://127.0.0.1:8080/api/patient/add/fn=`+ surname + `/sn=` + lastname)
      .map((res:Response) => res.json());
  }

  addPatientNew(surname: string, lastname: string, email: string){
    return this.http.request(`http://127.0.0.1:8080/api/patient/create/fn=`+surname+`/sn=`+lastname+`/email=`+email+`/pw=123/therapeut=1`)
  }

  getPatient(id){
    return this.http.request(`http://127.0.0.1:8080/api/patient/get/id=`+id).map((res:Response) => res.json());
  }

  getPatientbySurname(surname: string){
    return this.http.request(`http://127.0.0.1:8080/api/patient/get/sn=`+surname).map((res:Response) => res.json());
  }

  getPatients(){
    return this.http.request(`http://127.0.0.1:8080/api/patient/get/`).map((res:Response) => res.json());
  }

  removePatient(id){
    return this.http.request(`http://127.0.0.1:8080/api/patient/remove/id=`+id).map((res:Response) => res.json());
  }

  changePatient(id, theraId, surname: string, lastname: string, email: string){
    return this.http.request(`http://127.0.0.1:8080/api/patient/update/id=`+ id +`/fn=`+lastname+`/sn=`+surname+`/email=`+email+`/therapeut=`+ 1)
  }
}
