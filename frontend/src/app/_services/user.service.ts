import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import {Therapeut} from "../_classes/Therapeut";


@Injectable()
export class UserService {

  private baseUrl : string;

  constructor (private http: Http) {
    this.baseUrl = 'http://127.0.0.1:8080/api/praxis';
  }

  getAll() {
    return this.http.get(this.baseUrl, this.jwt()).map((response: Response) => response.json());
  }

  getById(id: number) {
    return this.http.get(this.baseUrl+ '/' + id, this.jwt()).map((response: Response) => response.json());
  }

  create(user: Therapeut) {
    return this.http.post(this.baseUrl, user, this.jwt()).map((response: Response) => response.json());
  }

  update(user: Therapeut) {
    return this.http.put(this.baseUrl + '/update/' + user.id, user, this.jwt()).map((response: Response) => response.json());
  }

  delete(id: number) {
    return this.http.delete('/delete/' + id, this.jwt()).map((response: Response) => response.json());
  }

  // private helper methods

  private jwt() {
    // create authorization header with jwt token
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
      return new RequestOptions({ headers: headers });
    }
  }
}
