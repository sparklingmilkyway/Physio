import {ExerciseComponent} from "../_components/_exercise_components/exercise/exercise.component";
import {AuthGuard} from "../_guards/auth.guard";
import {ExerciseDetailsComponent} from "../_components/_exercise_components/exercise-details/exercise-details.component";
import {ProgrammComponent} from "../_components/_programm_components/programm/programm.component";
import {ProgrammDetailsComponent} from "../_components/_programm_components/programm-details/programm-details.component";

export const programmRouting = [
  {path: 'programm', component: ProgrammComponent, canActivate: [AuthGuard] },
  {path: 'programm/:id', component:  ProgrammDetailsComponent, canActivate: [AuthGuard]}

];

export const programmRoutingComponent = [
  ProgrammComponent,
  ProgrammDetailsComponent
]

