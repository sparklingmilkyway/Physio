import {Injectable, OnInit} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';

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
}
