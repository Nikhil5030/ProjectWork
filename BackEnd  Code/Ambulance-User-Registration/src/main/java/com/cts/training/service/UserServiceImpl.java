package com.cts.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.bean.User;
import com.cts.training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> fetchAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> fetchUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User fetchUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> fetchUserByLocation(String location) {
		return userRepository.findByLocation(location);
	}

	@Override
	public void dropUser(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User verifyUser(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public User modifyUser(User user) {
		return userRepository.save(user);
	}

}
