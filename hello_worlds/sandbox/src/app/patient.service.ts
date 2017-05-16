import {Injectable, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class PatientService implements OnInit{

  ngOnInit(){

  }
  constructor(private http: Http) {
  }

  addPatient(){
    return this.http.request(`http://127.0.0.1:8080/api/patient/add/`)
      .map((res:Response) => res.json());
  }
}
