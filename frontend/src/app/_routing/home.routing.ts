import {AuthGuard} from "../_guards/auth.guard";
import {HomeComponent} from "../_components/home/home.component";


export const homeRouting = [{
  path: 'home', component: HomeComponent , canActivate: [AuthGuard]
}];

export const homeRoutingComponent = [
  HomeComponent
]

