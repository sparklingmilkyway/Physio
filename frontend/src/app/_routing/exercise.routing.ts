import {ExerciseComponent} from "../_components/_exercise_components/exercise/exercise.component";
import {AuthGuard} from "../_guards/auth.guard";

export const exerciseRouting = [{
  path: 'exercise', component: ExerciseComponent, canActivate: [AuthGuard]
}];

export const exerciseRoutingComponent = [
  ExerciseComponent
]

