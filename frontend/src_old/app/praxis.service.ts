import {Injectable, OnInit} from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class PraxisService implements OnInit {

  ngOnInit() {
  }

  constructor (
    private http: Http
  ) {}

  addPraxis() {
    /*return this.http.get(`http://127.0.0.1:8080/api/praxis/add`)
      .map((res:Response) => res.json());*/

    return this.http.request(`http://127.0.0.1:8080/api/praxis/add/`)
      .map((res:Response) => res.json());
  }

  addTherapeuts() {

    return this.http.request(`http://127.0.0.1:8080/api/praxis/addTherapeuts`)
      .map((res:Response) => res.json());
  }

  getTherapeuts() {

    return this.http.request(`http://127.0.0.1:8080/api/praxis/getTherapeuts`)
      .map((res:Response) => res.json());
  }

}
