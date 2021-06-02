import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ambulance } from '../Model/ambulance';
import { AmbulanceService } from '../services/ambulance.service';

@Component({
  selector: 'app-ambulances',
  templateUrl: './ambulances.component.html',
  styleUrls: ['./ambulances.component.css']
})
export class AmbulancesComponent implements OnInit {

  ambulances: Ambulance[];

  constructor(private ambulanceService:AmbulanceService,private router: Router) { }

  ngOnInit(): void {

    this.ambulanceService.getAllAmbulances().subscribe(data => {
      this.ambulances=data;
});

  }

  updateAmbulance(ambulance: Ambulance): void {
    localStorage.removeItem('id');
    localStorage.setItem('id',ambulance.id.toString());
    this.router.navigate(['update-ambulance']);
}

  deleteAmbulance(ambulance: Ambulance): void {
    this.ambulanceService.deleteAmbulanceById(ambulance.id).subscribe();
    this.ambulances=this.ambulances.filter(u => u !==ambulance);
  }

  showAmbulance(ambulance: Ambulance): void {
    localStorage.removeItem('id');
    localStorage.setItem('id',ambulance.id.toString());
    this.router.navigate(['show-ambulance']);
}
}



