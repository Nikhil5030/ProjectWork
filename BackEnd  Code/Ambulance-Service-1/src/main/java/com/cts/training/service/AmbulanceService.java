package com.cts.training.service;

import java.util.List;
import java.util.Optional;

import com.cts.training.bean.Ambulance;

public interface AmbulanceService {

	boolean addAmbulance(Ambulance ambulance);
	
	boolean updateAmbulanceDetails(Ambulance ambulance);
	
	List<Ambulance> showAmbulanceDetails(String location);
	
	boolean deleteAmbulance(Long id);

	List<Ambulance> findAll();

    Optional<Ambulance> showAmbulanceDetailsById(Long id);
}
