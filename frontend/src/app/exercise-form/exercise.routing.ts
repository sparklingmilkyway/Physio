/**
 * Created by Jonas on 26.05.2017.
 */

import {ExerciseFormComponent} from "../exercise-form/exercise-form.component";
import {ExerciseAddFormComponent} from "./exercise-add-form/exercise-add-form.component";
import {ExerciseSearchFormComponent} from "./exercise-search-form/exercise-search-form.component";

export const exerciseRouting = [{
    path: 'Übungen', component: ExerciseFormComponent,
    children: [
      {path:'Hinzufügen', component: ExerciseAddFormComponent},
      {path:'Suchen', component: ExerciseSearchFormComponent}
    ]
}];

export const exerciseRoutingComponents = [
  ExerciseAddFormComponent,
  ExerciseFormComponent,
  ExerciseSearchFormComponent
]
