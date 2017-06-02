
import {PatientComponent} from "../_components/patient_components/patient/patient.component";
import {PatientAddComponent} from "../_components/patient_components/patient-add/patient-add.component";
import {AddComponent} from "../_components/add/add.component";
export const addRouting = [{
  path: 'add', component: AddComponent,
  children: [
    {path:'patientadd', component: PatientAddComponent},
//    {path:'exerciseadd', component: },
  //  {path:'progroammadd', component: }

  ]
}];

export const addRoutingComponent = [
  AddComponent,
  PatientAddComponent
]

