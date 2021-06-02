import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAmbulanceComponent } from './ambulances/add-ambulance/add-ambulance.component';
import { AmbulanceComponent } from './ambulances/ambulance/ambulance.component';
import { AmbulancesComponent } from './ambulances/ambulances.component';
import { UpdateAmbulanceComponent } from './ambulances/update-ambulance/update-ambulance.component';

const routes: Routes = [
  { path:'', component:AmbulancesComponent},
  { path:'add-ambulance', component:AddAmbulanceComponent},
  { path:'update-ambulance', component:UpdateAmbulanceComponent},
  { path:'show-ambulance', component:AmbulanceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
