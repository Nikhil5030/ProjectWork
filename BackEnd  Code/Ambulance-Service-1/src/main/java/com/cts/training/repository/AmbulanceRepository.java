package com.cts.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.bean.Ambulance;

public interface AmbulanceRepository extends JpaRepository <Ambulance, Long>{

	List<Ambulance> findByLocation(String location);
	
	Optional<Ambulance> findById(Long id);

}
