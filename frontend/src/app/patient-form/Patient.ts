import {Therapeut} from "../Therapeut";
/**
 * Created by Jonas on 17.05.2017.
 */

export class Patient{
  id: number;
  surname: string;
  firstname: string;
  email: string;
  therapeut: Therapeut;

  constructor(firstname: string, surname: string, email: string, therapeut: Therapeut){
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
