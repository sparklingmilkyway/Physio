export class Therapeut{

  id: number;
  firstname: string;
  surname: string;
  email: string;
  password: string;

  constructor(id: number, firstname: string, surname: string, email: string, password: string){
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }

  update(id : number, firstname: string, surname: string, email: string, password: string){
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }
}
