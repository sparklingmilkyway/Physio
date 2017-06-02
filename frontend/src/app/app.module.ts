import {routingComponents, appRouting} from './_routing/app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms';


import { PopupModule } from 'ng2-opd-popup';
import {PatientComponent} from "./_components/patient_components/patient/patient.component";
import {ExerciseComponent} from "./_components/exercise/exercise.component";
import {SearchComponent} from "./_components/search/search.component";
import {HomeComponent} from "./_components/home/home.component";
import {AddComponent} from "./_components/add/add.component";
import {AppComponent} from "./app.component";
import {PraxisService} from "./_services/praxis.service";
import {TabComponent, TabsComponent} from "./_navigation/tabs/tabs.component";
import { LoginComponent } from './_components/login/login.component';
import { PatientAddComponent } from './_components/patient_components/patient-add/patient-add.component';


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
    PatientAddComponent
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
