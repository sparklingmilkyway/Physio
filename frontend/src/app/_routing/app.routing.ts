/**
 * Created by Jonas on 23.05.2017.
 */

import{RouterModule, Routes} from '@angular/router';
import {addRouting, addRoutingComponent} from "./add.routing";
import {exerciseRouting, exerciseRoutingComponent} from "./exercise.routing";
import {patientRouting, patientRoutingComponent} from "./patient.routing";
import {homeRouting, homeRoutingComponent} from "./home.routing";
import {searchRouting, searchRoutingComponent} from "./search.routing";
import {LoginComponent} from "../_components/_login_components/login/login.component";
import {programmRouting, programmRoutingComponent} from "./programm.routing";


/**
 *
 * @type {[{path: string; component: WelcomeFormComponent},{path: string; component: ExerciseFormComponent},{path: string; component: ProgramFormComponent},{path: string; component: AdminComponent},any,any]}
 *
 * this is the very root component of our angular Routes. These are necessary to properly navigate through our application.
 */
export const appRoutes: Routes = [{
  path: 'login', component: LoginComponent,
},
...addRouting,
  ...homeRouting,
  ...searchRouting,
  ...exerciseRouting,
  ...programmRouting,
  ...patientRouting
];

export const appRouting = RouterModule.forRoot(appRoutes);


export const routingComponents = [

  LoginComponent,
  ...addRoutingComponent,
  ...searchRoutingComponent,
  ...homeRoutingComponent,
  ...exerciseRoutingComponent,
  ...programmRoutingComponent,
  ...patientRoutingComponent
];
