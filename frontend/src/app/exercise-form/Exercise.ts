import {Therapeut} from "../Therapeut";
/**
 * Created by Jonas on 26.05.2017.
 */

export class Exercise{
  id: number;
  therapeut: Therapeut;
  name: string;
  type: string;

  constructor( name: string, type: string, therapeut: Therapeut){
    this.name = name;
    this.type = type;
    this.therapeut = therapeut;
  }

  update(id: number, name: string, type: string, therapeut: Therapeut){
    this.id = id;
    this.name = name;
    this.type = type;
    this.therapeut = therapeut;
  }
}
