import {Patient} from "./Patient";

export class Programm{

  id: number;
  //programmComponents: ProgrammComponent[];
  name: string;
  patient: Patient;

  constructor(id: number, /* programmComponents: ProgrammComponent[], */ name: string, patient: Patient){
    this.id = id;
    // this.programmComponents = programmComponents;
    this.name = name;
    this.patient = patient;
  }

  update(id: number, /* programmComponents: ProgrammComponent[], */ name: string, patient: Patient){
    this.id = id;
    // this.programmComponents = programmComponents;
    this.name = name;
    this.patient = patient;
  }
}
