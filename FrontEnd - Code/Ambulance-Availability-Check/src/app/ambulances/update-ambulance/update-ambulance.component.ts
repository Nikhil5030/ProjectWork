import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AmbulanceService } from 'src/app/services/ambulance.service';

@Component({
  selector: 'app-update-ambulance',
  templateUrl: './update-ambulance.component.html',
  styleUrls: ['./update-ambulance.component.css']
})
export class UpdateAmbulanceComponent implements OnInit {

  updateForm: FormGroup;

  constructor(private ambulanceService:AmbulanceService,private router: Router) { }

  ngOnInit(): void {

    this.updateForm = new FormGroup({
      id: new FormControl(null, Validators.required),
      vehicleNo: new FormControl(null, Validators.required),
      driverName: new FormControl(null, Validators.required),
      age: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      hospital: new FormControl(null, Validators.required),
      location: new FormControl(null, Validators.required),
      phoneNo: new FormControl(null, Validators.required)
     
  });

  const id=localStorage.getItem('id');
  if (+id > 0) {
       this.ambulanceService.getAmbulanceById(+id).subscribe(data => {
            this.updateForm.patchValue(data);
       });
  }
  }

  onSubmit(): void {

    this.ambulanceService.updateAmbulance(this.updateForm.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['']);
},
error => {
      alert(error);
});

  }
}
