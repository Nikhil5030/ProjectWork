package com.cts.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.bean.Ambulance;
import com.cts.training.repository.AmbulanceRepository;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {
	
	@Autowired
	private AmbulanceRepository repository;

	@Override
	public boolean addAmbulance(Ambulance ambulance) {
		repository.save(ambulance);
		return true;
	}

	@Override
	public boolean updateAmbulanceDetails(Ambulance ambulance) {
		repository.save(ambulance);
		return true;
	}

	@Override
	public List<Ambulance> showAmbulanceDetails(String location) {
		return repository.findByLocation(location);
	}

	@Override
	public boolean deleteAmbulance(Long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<Ambulance> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<Ambulance> showAmbulanceDetailsById(Long id) {
		return repository.findById(id);
	}

}
