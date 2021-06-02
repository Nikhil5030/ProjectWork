package com.cts.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bean.Ambulance;

import com.cts.training.repository.AmbulanceRepository;
import com.cts.training.service.AmbulanceService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class AmbulanceController {
	
	@Autowired
	private AmbulanceService ambulanceService;
	
	@GetMapping("/hello")
	public String message() {
		return "Hello From Ambulance Controller";
	}
	
	@GetMapping("/ambulances")
	public List<Ambulance> getAllAmbulances(){
		return ambulanceService.findAll();
	}
	
	@GetMapping("/ambulances/{id}")
	public ResponseEntity<?>  displayAmbulance(@PathVariable Long id) {
		if(id != 0) {
			Optional<Ambulance> amb1 = ambulanceService.showAmbulanceDetailsById(id);
			return new ResponseEntity<>(amb1, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No ambulance Found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/ambulances")
	public ResponseEntity<?>  saveAmbulance(@RequestBody Ambulance ambulance) {
		if(ambulance != null) {
			ambulanceService.updateAmbulanceDetails(ambulance);
			return new ResponseEntity<>(ambulance, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No ambulance Found", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/ambulances")
	public ResponseEntity<?>  updateAmbulance(@RequestBody Ambulance ambulance) {
		if(ambulance != null) {
			ambulanceService.addAmbulance(ambulance);
			return new ResponseEntity<>(ambulance, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No ambulance Found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ambulances/location/{location}")
	/*public ResponseEntity<?>  displayAmbulance(@PathVariable String location) {
		if(location != null) {
			List<Ambulance> amb = ambulanceService.showAmbulanceDetails(location);
			return new ResponseEntity<>(amb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No ambulance Found", HttpStatus.NOT_FOUND);
		}
	}*/public List<Ambulance> displayAmbulances(@PathVariable String location){
		return ambulanceService.showAmbulanceDetails(location);
	}
	
	@DeleteMapping("/ambulances/{id}")
	public ResponseEntity<?>  deleteAmbulanceDetails(@PathVariable Long id) {
		if(id != 0) {
			ambulanceService.deleteAmbulance(id);
			return new ResponseEntity<>("Ambulance Data Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No ambulance Found", HttpStatus.NOT_FOUND);
		}
	}
}
