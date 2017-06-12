import {routingComponents, appRouting} from './_routing/app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms';


import { PopupModule } from 'ng2-opd-popup';
import {PatientComponent} from "./_components/_patient_components/patient/patient.component";
import {ExerciseComponent} from "./_components/_exercise_components/exercise/exercise.component";
import {SearchComponent} from "./_components/search/search.component";
import {HomeComponent} from "./_components/home/home.component";
import {AddComponent} from "./_components/add/add.component";
import {AppComponent} from "./app.component";
import {PraxisService} from "./_services/praxis.service";
import {TabComponent, TabsComponent} from "./_navigation/tabs/tabs.component";
import { LoginComponent } from './_components/_login_components/login/login.component';
import { PatientAddComponent } from './_components/_patient_components/patient-add/patient-add.component';
import { ExerciseAddComponent } from './_components/_exercise_components/exercise-add/exercise-add.component';
import { ProgrammAddComponent } from './_components/_programm_components/programm-add/programm-add.component';
import { ExerciseSearchComponent } from './_components/_exercise_components/exercise-search/exercise-search.component';
import { PatientSearchComponent } from './_components/_patient_components/patient-search/patient-search.component';
import { ProgrammSearchComponent } from './_components/_programm_components/programm-search/programm-search.component';
import { RegisterComponent } from './_components/_login_components/register/register.component';
import {AuthGuard} from "./_guards/auth.guard";
import {AlertService} from "./_services/alert.service";
import {AuthenticationService} from "./_services/authentication.service";
import {UserService} from "./_services/user.service";
import {AlertComponent} from "./_directives/alert.component";
import { AddOverviewComponent } from './_components/add-overview/add-overview.component';
import { ExerciseDetailsComponent } from './_components/_exercise_components/exercise-details/exercise-details.component';
import { PatientDetailsComponent } from './_components/_patient_components/patient-details/patient-details.component';
import { ProgrammComponent } from './_components/_programm_components/programm/programm.component';
import { ProgrammDetailsComponent } from './_components/_programm_components/programm-details/programm-details.component';


@NgModule({
  declarations: [
    routingComponents,
    PatientComponent,
    ExerciseComponent,
    SearchComponent,
    HomeComponent,
    AddComponent,
    AppComponent,
    TabsComponent,
    TabComponent,
    LoginComponent,
    PatientAddComponent,
    ExerciseAddComponent,
    ProgrammAddComponent,
    ExerciseSearchComponent,
    PatientSearchComponent,
    ProgrammSearchComponent,
    RegisterComponent,
    AlertComponent,
    AddOverviewComponent,
    ExerciseDetailsComponent,
    PatientDetailsComponent,
    ProgrammComponent,
    ProgrammDetailsComponent

    //
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    appRouting,
    PopupModule.forRoot()
  ],
  providers: [
    PraxisService,
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
