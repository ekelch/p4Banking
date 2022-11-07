package com.revature.services;

import java.util.Optional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

public class UserService {
	
	public UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findByCredentials(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
}
