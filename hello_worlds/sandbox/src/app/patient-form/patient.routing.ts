/**
 * Created by Jonas on 23.05.2017.
 */
import {PatientAddFormComponent} from "./patient-add-form/patient-add-form.component";
import {PatientFormComponent} from "../patient-form/patient-form.component";
import {PatientManipulateFormComponent} from "./patient-manipulate-form/patient-manipulate-form.component";
import {PatientDetailsFormComponent} from "./patient-details-form/patient-details-form.component";
/**
 * Created by Jonas on 23.05.2017.
 */
export const patientRouting = [{
  path: 'Patienten', component: PatientFormComponent,
  children: [
    {path:'Hinzufügen', component: PatientAddFormComponent},
    {path:'Suchen', component: PatientManipulateFormComponent}
  ]
}];

export const patientRoutingComponents = [
  PatientFormComponent,
  PatientAddFormComponent
]

