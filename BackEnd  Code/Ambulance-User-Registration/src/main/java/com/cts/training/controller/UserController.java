package com.cts.training.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.cts.training.bean.User;
import com.cts.training.exception.UserNotFoundException;
import com.cts.training.repository.UserRepository;
import com.cts.training.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/hello")
	public String message() {
		return "Hello from User Registration api";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.fetchAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
	Optional<User> user=userService.fetchUserById(id);
	if(!user.isPresent()) 
		throw new UserNotFoundException("The user with Id - :"+id+"does not exists");
	     return user;
	 
	}
	
	@GetMapping("/users/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
	return userService.fetchUserByUsername(username);
	}
	
	@GetMapping("/users/location/{location}")
	public List<User> getUserByLocation(@PathVariable String location) {
	return userService.fetchUserByLocation(location);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		Optional<User> user=userService.fetchUserById(id);
		if(!user.isPresent()) 
			throw new UserNotFoundException("The user with Id - :"+id+"does not exists");
		userService.dropUser(id);
		
	}
	
	
	
	@PostMapping("/users")
	public User insertUser(@RequestBody User user) throws Exception {
		User userByUsername=userService.fetchUserByUsername(user.getUsername());
		if(userByUsername != null) {
			throw new Exception("User with Username:"+user.getUsername()+" already exists");
		}
		else {
		User userObj=null;
		userObj=userService.createUser(user);
		return userObj;
		}
	}
	
	@PostMapping("/users/validate")
	public User validateUser(@RequestBody User user) throws Exception {
		User findUser=userService.verifyUser(user);
		if(findUser == null) {
			throw new Exception("Bad Credentials");
		}
		return findUser;
	}
	
	
	@PutMapping("/users")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		userService.modifyUser(user);
		return new ResponseEntity<>("Data Updated Successfully",HttpStatus.OK);
	}

}
