import {Injectable, OnInit} from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import {Therapeut} from "../_classes/Therapeut";

@Injectable()
export class PraxisService implements OnInit {

  private baseUrl : string;

  ngOnInit() {
  }

  constructor (
    private http: Http
  ) {
    this.baseUrl = 'http://127.0.0.1:8080/api/praxis';
  }

  // POST METHODS

  addTherapeut(therapeut : Therapeut) {
    return this.http.post(this.baseUrl+'/thearpeut/', therapeut).map((res:Response) => res.json());
  }


  // GET METHODS

  getPraxis() {
    return this.http.get(this.baseUrl).map((res:Response) => res.json());
  }

  getTherapeut(id) {
    return this.http.get(this.baseUrl+'/thearpeut/'+id).map((res:Response) => res.json());
  }

  getTherapeuts() {
    return this.http.get(this.baseUrl+'/thearpeut/').map((res:Response) => res.json());
  }


}
