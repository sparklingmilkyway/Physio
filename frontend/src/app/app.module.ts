<<<<<<< HEAD
import {routingComponents, appRouting} from './app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import {TabComponent, TabsComponent} from './tabs/tabs.component';
import { WelcomeFormComponent } from './welcome-form/welcome-form.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { ExerciseFormComponent } from './exercise-form/exercise-form.component';
import { ProgramFormComponent } from './program-form/program-form.component';
import {PraxisService} from "./praxis.service";
import { PatientAddFormComponent } from './patient-form/patient-add-form/patient-add-form.component';
import { PatientManipulateFormComponent } from './patient-form/patient-manipulate-form/patient-manipulate-form.component';
import { PatientDetailsFormComponent } from './patient-form/patient-details-form/patient-details-form.component';
import { ExerciseAddFormComponent } from './exercise-form/exercise-add-form/exercise-add-form.component';
import { ExerciseDetailFormComponent } from './exercise-form/exercise-detail-form/exercise-detail-form.component';
import { ExerciseSearchFormComponent } from './exercise-form/exercise-search-form/exercise-search-form.component';
import { PopupModule } from 'ng2-opd-popup';
import { ProgramCreateFormComponent } from './program-form/program-create-form/program-create-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    TabsComponent,
    TabComponent,
    WelcomeFormComponent,
    PatientFormComponent,
    ExerciseFormComponent,
    ProgramFormComponent,
    routingComponents,
    PatientAddFormComponent,
    PatientManipulateFormComponent,
    PatientDetailsFormComponent,
    ExerciseAddFormComponent,
    ExerciseDetailFormComponent,
    ExerciseSearchFormComponent,
    ProgramCreateFormComponent
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
  providers: [PraxisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
=======
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
    AlertComponent

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
>>>>>>> newfrontend
