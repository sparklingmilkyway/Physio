
import {PatientComponent} from "../_components/_patient_components/patient/patient.component";
import {PatientAddComponent} from "../_components/_patient_components/patient-add/patient-add.component";
import {AddComponent} from "../_components/add/add.component";
import {ExerciseAddComponent} from "../_components/_exercise_components/exercise-add/exercise-add.component";
import {ProgrammAddComponent} from "../_components/_programm_components/programm-add/programm-add.component";
import {HomeComponent} from "../_components/home/home.component";
import {SearchComponent} from "../_components/search/search.component";
import {AuthGuard} from "../_guards/auth.guard";
import {PatientDetailsComponent} from "../_components/_patient_components/patient-details/patient-details.component";
export const patientRouting = [{
  path: 'patient', component: PatientComponent, canActivate: [AuthGuard]
},
  {path: 'patient/:id', component:  PatientDetailsComponent, canActivate: [AuthGuard]}

];

export const patientRoutingComponent = [
  SearchComponent,
  PatientDetailsComponent,
  PatientComponent
]

