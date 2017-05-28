/**
 * Created by Jonas on 23.05.2017.
 */

import{RouterModule, Routes} from '@angular/router';

import {WelcomeFormComponent} from "./welcome-form/welcome-form.component";
import {PatientFormComponent} from "./patient-form/patient-form.component";
import {ExerciseFormComponent} from "./exercise-form/exercise-form.component";
import {ProgramFormComponent} from "./program-form/program-form.component";
import {AdminComponent} from "app/admin/admin.component";
import {PatientAddFormComponent} from "./patient-form/patient-add-form/patient-add-form.component";
import {patientRouting, patientRoutingComponents} from "./patient-form/patient.routing";
import {exerciseRouting, exerciseRoutingComponents} from "./exercise-form/exercise.routing";

/**
 *
 * @type {[{path: string; component: WelcomeFormComponent},{path: string; component: ExerciseFormComponent},{path: string; component: ProgramFormComponent},{path: string; component: AdminComponent},any,any]}
 *
 * this is the very root component of our angular Routes. Tese are necessary to properly navigate through our application.
 */
export const appRoutes: Routes = [
  {path: 'Home', component: WelcomeFormComponent},
  {path:'Übungen', component: ExerciseFormComponent},
  {path:'Programme', component: ProgramFormComponent},
  {path:'Admin', component: AdminComponent},
  ...patientRouting,
  ...exerciseRouting

];

export const appRouting = RouterModule.forRoot(appRoutes);



export const routingComponents = [
  WelcomeFormComponent,
  PatientFormComponent,
  ExerciseFormComponent,
  PatientAddFormComponent,
  ...patientRoutingComponents,
  ...exerciseRoutingComponents
];
