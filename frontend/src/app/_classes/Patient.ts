import {Therapeut} from "./Therapeut";

export class Patient{

  id: number;
  firstname: string;
  surname: string;
  email: string;
  therapeut: Therapeut;

  constructor(id: number, firstname: string, surname: string, email: string, therapeut: Therapeut){
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.therapeut = therapeut;
  }

  update(id : number, firstname: string, surname: string, email: string, therapeut: Therapeut){
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.therapeut = therapeut;
  }
}
