package com.revature.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.LoginRequest;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins={"http://localhost:8080", "http://localhost:4200"})
public class UserController {

	private UserService userService;
	private UserRepository userRepo;
	
	public UserController(UserService userService, UserRepository userRepo) {
		this.userService = userService;
		this.userRepo = userRepo;
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody LoginRequest loginRequest, HttpSession session) throws Exception{
		User user = userService.findByCredentials(loginRequest.getUsername(), loginRequest.getPassword());
		session.setAttribute("user", user);
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping("/test")
	public ResponseEntity<User> test() {
		Optional<User> user = userRepo.findById(6);
		return ResponseEntity.ok(user.get());
	}
	
	@GetMapping
	public ResponseEntity<User> getUser(HttpSession session) throws UserNotFoundException {
		Object uncheckedUser = session.getAttribute("user");
		if (uncheckedUser instanceof User) {
			User user = (User) uncheckedUser.getClass().cast(uncheckedUser);
			return ResponseEntity.ok(user);
		}
		else
			throw new UserNotFoundException("User not found");
		
	}

}
