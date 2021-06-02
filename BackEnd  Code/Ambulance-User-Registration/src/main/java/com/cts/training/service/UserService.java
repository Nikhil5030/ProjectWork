package com.cts.training.service;

import java.util.List;
import java.util.Optional;

import com.cts.training.bean.User;

public interface UserService {
   
	List<User> fetchAllUsers();
	
	Optional<User> fetchUserById(Long id);
	
	User fetchUserByUsername(String username);
	 
	List<User> fetchUserByLocation(String location);
	
	 void dropUser(Long id);
	 
	 User createUser(User user);
	 
	 User verifyUser(User user);
	 
	 User modifyUser(User user);
	 
}
