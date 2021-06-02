package com.cts.training.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ambulance {
	
	@Id
	private Long id;
	private String vehicleNo;
	private String driverName;
	private String age;
	private String gender;
	private String hospital;
	private String location;
	private Long phoneNo;
	
	public Ambulance() {
		
	}

	public Ambulance(Long id, String vehicleNo, String driverName, String age, String gender, String hospital,
			String location, Long phoneNo) {
		super();
		this.id = id;
		this.vehicleNo = vehicleNo;
		this.driverName = driverName;
		this.age = age;
		this.gender = gender;
		this.hospital = hospital;
		this.location = location;
		this.phoneNo = phoneNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	

}
