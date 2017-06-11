
import {PatientComponent} from "../_components/_patient_components/patient/patient.component";
import {PatientAddComponent} from "../_components/_patient_components/patient-add/patient-add.component";
import {AddComponent} from "../_components/add/add.component";
import {ExerciseAddComponent} from "../_components/_exercise_components/exercise-add/exercise-add.component";
import {ProgrammAddComponent} from "../_components/_programm_components/programm-add/programm-add.component";
import {AddOverviewComponent} from "../_components/add-overview/add-overview.component";
import {AuthGuard} from "../_guards/auth.guard";
export const addRouting = [{
  path: 'add', component: AddComponent, canActivate: [AuthGuard],
  children: [
    {path:'patientadd', component: PatientAddComponent},
    {path:'exerciseadd', component: ExerciseAddComponent},
    {path:'programmadd', component: ProgrammAddComponent},
    {path:'overview', component: AddOverviewComponent}


  ]
}];

export const addRoutingComponent = [
  AddComponent,
  PatientAddComponent,
  ExerciseAddComponent,
  ProgrammAddComponent
]

