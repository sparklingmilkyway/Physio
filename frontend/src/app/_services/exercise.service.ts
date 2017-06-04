import {Injectable, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';
import {Exercise} from "../_classes/Exercise";

/**
 * this is a so called service from the Angular framework. the goal is ti have exactly one injectable instance who makes
 * calls to our server. these uri calls are static. e.g. the method "addExercise" requires three parameters. then it does a http request
 * to our jbos server with the described uri with given parameters. the return value from the server will be saved into a json file.
 * The Object type form java is Response.
*
 */
@Injectable()
export class ExerciseService implements OnInit{

  private baseUrl : string;

  ngOnInit(){

  }

  constructor(private http: Http) {
    this.baseUrl = "http://127.0.0.1:8080/api/exercise";
  }


  // POST METHODS
  addExercise(exercise : Exercise) {
    return this.http.post(this.baseUrl, exercise).map((res:Response) => res.json());
  }

  changeExercise(exercise : Exercise){
    return this.http.post(this.baseUrl+'/update', exercise).map((res:Response) => res.json());
  }


  // GET METHODS

  getExercise(id){
    return this.http.get(this.baseUrl+"/"+id).map((res:Response) => res.json());
  }

  getExercises(){
    return this.http.get(this.baseUrl).map((res:Response) => res.json());
  }


  // REQUEST METHODS

  removeExercise(id){
    return this.http.request(this.baseUrl+`/remove/`+id).map((res:Response) => res.json());
  }



}
