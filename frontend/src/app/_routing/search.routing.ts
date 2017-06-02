
import {PatientComponent} from "../_components/patient_components/patient/patient.component";
import {PatientAddComponent} from "../_components/patient_components/patient-add/patient-add.component";
import {AddComponent} from "../_components/add/add.component";
import {ExerciseAddComponent} from "../_components/exercise_components/exercise-add/exercise-add.component";
import {ProgrammAddComponent} from "../_components/programm_components/programm-add/programm-add.component";
import {HomeComponent} from "../_components/home/home.component";
import {SearchComponent} from "../_components/search/search.component";
import {PatientSearchComponent} from "../_components/patient_components/patient-search/patient-search.component";
import {ExerciseSearchComponent} from "../_components/exercise_components/exercise-search/exercise-search.component";
import {ProgrammSearchComponent} from "../_components/programm_components/programm-search/programm-search.component";
export const searchRouting = [{
  path: 'search', component: SearchComponent,

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

