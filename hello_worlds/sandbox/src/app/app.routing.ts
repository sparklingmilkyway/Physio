/**
 * Created by Jonas on 23.05.2017.
 */

import{RouterModule, Routes} from '@angular/router';

import {WelcomeFormComponent} from "./welcome-form/welcome-form.component";
import {PatientFormComponent} from "./patient-form/patient-form.component";
import {ExerciseFormComponent} from "./exercise-form/exercise-form.component";
import {ProgramFormComponent} from "./program-form/program-form.component";
import {AdminComponent} from "app/admin/admin.component";

export const appRoutes: Routes = [
  {path: 'Home', component: WelcomeFormComponent},
  {path:'Patienten', component: PatientFormComponent},
  {path:'Übungen', component: ExerciseFormComponent},
  {path:'Programme', component: ProgramFormComponent},
  {path:'Admin', component: AdminComponent}
];

export const appRouting = RouterModule.forRoot(appRoutes);

export const routingComponents = [
  WelcomeFormComponent,
  PatientFormComponent,
  ExerciseFormComponent
];
