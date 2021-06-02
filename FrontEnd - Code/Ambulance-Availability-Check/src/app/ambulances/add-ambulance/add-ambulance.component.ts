import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AmbulanceService } from 'src/app/services/ambulance.service';

@Component({
  selector: 'app-add-ambulance',
  templateUrl: './add-ambulance.component.html',
  styleUrls: ['./add-ambulance.component.css']
})
export class AddAmbulanceComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private ambulanceService:AmbulanceService,private router: Router) { }

  ngOnInit(): void {
    this.registerForm=new FormGroup({
      id: new FormControl(null, Validators.required),
      vehicleNo: new FormControl(null, Validators.required),
      driverName: new FormControl(null, Validators.required),
      age: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      hospital: new FormControl(null, Validators.required),
      location: new FormControl(null, Validators.required),
      phoneNo: new FormControl(null, Validators.required)
    });
  }

  onSubmit(): void{
    
    this.ambulanceService.insertAmbulance(this.registerForm.value).subscribe(data => {
      console.log("Ambulance data added successfully!")
      this.router.navigate(['']);
    })
     console.log(this.registerForm);
   }

}
