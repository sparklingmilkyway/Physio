import {ExerciseComponent} from "../_components/_exercise_components/exercise/exercise.component";
import {AuthGuard} from "../_guards/auth.guard";
import {ExerciseDetailsComponent} from "../_components/_exercise_components/exercise-details/exercise-details.component";

export const exerciseRouting = [
  {path: 'exercise', component: ExerciseComponent, canActivate: [AuthGuard] },
  {path: 'exercise/:id', component:  ExerciseDetailsComponent, canActivate: [AuthGuard]}

];

export const exerciseRoutingComponent = [
  ExerciseComponent,
  ExerciseDetailsComponent
]

