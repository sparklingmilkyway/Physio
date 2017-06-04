import {Therapeut} from "./Therapeut";

/**
 * The exercise model is a small class that defines the properties of an exercise.
 */
export class Exercise{

  id: number;
  name: string;
  type: string;
  therapeut: Therapeut;

  constructor (id: number,  name: string,  type: string,  therapeut: Therapeut) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.therapeut = therapeut;
  }

  update(id: number,  name: string,  type: string,  therapeut: Therapeut) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.therapeut = therapeut;
  }
}
