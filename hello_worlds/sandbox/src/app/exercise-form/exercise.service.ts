import {Injectable, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';

/**
 * this is a so called service from the Angular framework. the goal is ti have exactly one injectable instance who makes
 * calls to our server. these uri calls are static. e.g. the method "addExercise" requires three parameters. then it does a http request
 * to our jbos server with the described uri with given parameters. the return value from the server will be saved into a json file.
 * The Object type form java is Response.
*
 */
@Injectable()
export class ExerciseService implements OnInit{

  ngOnInit(){

  }
 constructor(private http: Http) { }

 addExercise(name: string, type: string, therapeut: number){
 return this.http.request(`http://127.0.0.1:8080/api/exercise/create/name=`+ name + `/type=` + type+`/therapeut=`+therapeut)
 .map((res:Response) => res.json());
 }

 getExercises(){
    return this.http.request(`http://127.0.0.1:8080/api/exercise/get/`).map((res:Response) => res.json());
 }

 getExercise(id: number){
   return this.http.request(`http://127.0.0.1:8080/api/exercise/get/id=`+id)
     .map((res:Response) => res.json());
 }
 changeExercise(id: number,name: string,type: string){
   return this.http.request(`http://127.0.0.1:8080/api/exercise/update/id=`+id+`/name=`+name+`/type=`+type+`/therapeut=`+1);
 }

 removeExercise(id: number){
    return this.http.request(`http://127.0.0.1:8080/api/exercise/remove/id=`+id)
      .map((res:Response) => res.json());
 }
}
