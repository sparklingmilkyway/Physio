/**
 * The UserDTO model is a small class that defines the properties of a UserDTO.
 * Is used for the auth interaction with the backend
 */
export class UserDTO{

  id: number;
  firstname: string;
  surname: string;
  email: string;
  password: string;
  token: string;

  constructor(id: number, firstname: string, surname: string, email: string, password: string, token: string){
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.token = token;
  }

}
