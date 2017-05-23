import {Injectable, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class PatientService implements OnInit{

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
}
