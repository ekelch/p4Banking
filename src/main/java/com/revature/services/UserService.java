package com.revature.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	public UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByCredentials(String username, String password) throws UserNotFoundException {
		Optional<User> user =  userRepository.findByUsernameAndPassword(username, password);
		if (user.isPresent())
			return user.get();
		else
			throw new UserNotFoundException("User not found");
	}

	public User findById(int id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		else
			throw new UserNotFoundException("User not found");
	}
	
}
