import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import {LoginReq} from "../_classes/LoginReq";

/**
 * The authentication service is used to login and logout of the application,
 * to login it posts the users credentials to the api and checks the response for a JWT token,
 * if there is one it means authentication was successful so the user details including the token are added to local storage.
 *
 * The logged in user details are stored in local storage
 * so the user will stay logged in if they refresh the browser and also between browser sessions until they logout.
 * If you don't want the user to stay logged in between refreshes or sessions
 * the behaviour could easily be changed by storing user details somewhere less persistent
 * such as session storage or in a property of the authentication service.
 */
@Injectable()
export class AuthenticationService {

  private baseUrl : string;
  private loginReq : LoginReq;

  constructor(private http: Http) {
    this.baseUrl = "http://127.0.0.1:8080/api/authenticate";
  }

  login(email: string, password: string) {
    this.loginReq = new LoginReq(email, password);
    return this.http.post(this.baseUrl, this.loginReq)
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let userDTO = response.json();
        if (userDTO && userDTO.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(userDTO));
        }
      });
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
