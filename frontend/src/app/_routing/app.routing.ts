/**
 * Created by Jonas on 23.05.2017.
 */

import{RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "../_components/home/home.component";
import {SearchComponent} from "../_components/search/search.component";
import {AddComponent} from "../_components/add/add.component";
import {ExerciseComponent} from "../_components/exercise/exercise.component";
import {PatientComponent} from "../_components/patient_components/patient/patient.component";
import {addRouting, addRoutingComponent} from "./add.routing";


/**
 *
 * @type {[{path: string; component: WelcomeFormComponent},{path: string; component: ExerciseFormComponent},{path: string; component: ProgramFormComponent},{path: string; component: AdminComponent},any,any]}
 *
 * this is the very root component of our angular Routes. These are necessary to properly navigate through our application.
 */
export const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path:'search', component: SearchComponent},
  {path:'add', component: AddComponent},
  {path:'exercise', component: ExerciseComponent},
  {path:'patient', component: PatientComponent},

  ...addRouting
  //...patientRouting,
  //...exerciseRouting,
 // ...programRouting
];

export const appRouting = RouterModule.forRoot(appRoutes);


export const routingComponents = [

  HomeComponent,
  SearchComponent,
  AddComponent,
  ExerciseComponent,
  PatientComponent,

  ...addRoutingComponent
  // ...patientRoutingComponents,
  // ...exerciseRoutingComponents,
  // ...programRoutingComponents
];
