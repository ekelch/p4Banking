package com.revature.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	public UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findByCredentials(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public User findById(int id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		else
			throw new Exception("User not found");
	}
	
}
