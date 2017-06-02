import {ProgramFormComponent} from "./program-form.component";
import {ProgramCreateFormComponent} from "./program-create-form/program-create-form.component";
/**
 * Created by Jonas on 30.05.2017.
 */

export const programRouting = [{
  path: 'Programme', component: ProgramFormComponent,
  children: [
    {path: 'NewProg', component: ProgramCreateFormComponent}
  ]
}];

export const programRoutingComponents = [
  ProgramCreateFormComponent,
  ProgramFormComponent
]
