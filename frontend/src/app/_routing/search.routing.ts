
import {PatientComponent} from "../_components/_patient_components/patient/patient.component";
import {PatientAddComponent} from "../_components/_patient_components/patient-add/patient-add.component";
import {AddComponent} from "../_components/add/add.component";
import {ExerciseAddComponent} from "../_components/_exercise_components/exercise-add/exercise-add.component";
import {ProgrammAddComponent} from "../_components/_programm_components/programm-add/programm-add.component";
import {HomeComponent} from "../_components/home/home.component";
import {SearchComponent} from "../_components/search/search.component";
import {PatientSearchComponent} from "../_components/_patient_components/patient-search/patient-search.component";
import {ExerciseSearchComponent} from "../_components/_exercise_components/exercise-search/exercise-search.component";
import {ProgrammSearchComponent} from "../_components/_programm_components/programm-search/programm-search.component";
import {AuthGuard} from "../_guards/auth.guard";
export const searchRouting = [{
  path: 'search', component: SearchComponent, canActivate: [AuthGuard],

  children: [
    {path:'patientsearch', component: PatientSearchComponent},
    {path:'exercisesearch', component: ExerciseSearchComponent},
    {path:'programmsearch', component: ProgrammSearchComponent}

  ]
}];

export const searchRoutingComponent = [
  SearchComponent,
  PatientSearchComponent,
  ExerciseSearchComponent,
  ProgrammSearchComponent
]

