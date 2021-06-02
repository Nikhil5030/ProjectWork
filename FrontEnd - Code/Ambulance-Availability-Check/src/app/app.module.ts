import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AmbulancesComponent } from './ambulances/ambulances.component';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddAmbulanceComponent } from './ambulances/add-ambulance/add-ambulance.component';
import { UpdateAmbulanceComponent } from './ambulances/update-ambulance/update-ambulance.component';
import { AmbulanceComponent } from './ambulances/ambulance/ambulance.component';


@NgModule({
  declarations: [
    AppComponent,
    AmbulancesComponent,
    AddAmbulanceComponent,
    UpdateAmbulanceComponent,
    AmbulanceComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
