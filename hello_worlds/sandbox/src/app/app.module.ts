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
import { AdminComponent } from './admin/admin.component';
import { PatientAddFormComponent } from './patient-form/patient-add-form/patient-add-form.component';
import { PatientManipulateFormComponent } from './patient-form/patient-manipulate-form/patient-manipulate-form.component';
import {SubTabComponent, SubTabsComponent} from './sub-tabs/sub-tabs.component';
import { PatientDetailsFormComponent } from './patient-form/patient-details-form/patient-details-form.component';
import { ExerciseAddFormComponent } from './exercise-form/exercise-add-form/exercise-add-form.component';
import { ExerciseDetailFormComponent } from './exercise-form/exercise-detail-form/exercise-detail-form.component';
import { ExerciseDetailsFormComponent } from './exercise-form/exercise-details-form/exercise-details-form.component';
import { ExerciseSearchFormComponent } from './exercise-form/exercise-search-form/exercise-search-form.component';


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
    AdminComponent,
    routingComponents,
    PatientAddFormComponent,
    PatientManipulateFormComponent,
    SubTabsComponent,
    SubTabComponent,
    PatientDetailsFormComponent,
    ExerciseAddFormComponent,
    ExerciseDetailFormComponent,
    ExerciseDetailsFormComponent,
    ExerciseSearchFormComponent
    //
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    appRouting
  ],
  providers: [PraxisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
