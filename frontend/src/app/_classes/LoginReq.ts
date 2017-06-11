
/**
 * The login request model is a small class that defines the properties of a login request.
 */
export class LoginReq{

  email: string;
  password: string;

  constructor(email: string, password: string){
    this.email = email;
    this.password = password;
  }

}
