
import {PatientComponent} from "../_components/patient_components/patient/patient.component";
import {PatientAddComponent} from "../_components/patient_components/patient-add/patient-add.component";
import {AddComponent} from "../_components/add/add.component";
import {ExerciseAddComponent} from "../_components/exercise_components/exercise-add/exercise-add.component";
import {ProgrammAddComponent} from "../_components/programm_components/programm-add/programm-add.component";
export const addRouting = [{
  path: 'add', component: AddComponent,
  children: [
    {path:'patientadd', component: PatientAddComponent},
    {path:'exerciseadd', component: ExerciseAddComponent},
    {path:'programmadd', component: ProgrammAddComponent}

  ]
}];

export const addRoutingComponent = [
  AddComponent,
  PatientAddComponent,
  ExerciseAddComponent,
  ProgrammAddComponent
]
