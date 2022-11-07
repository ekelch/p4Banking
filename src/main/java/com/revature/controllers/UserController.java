package com.revature.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.LoginRequest;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="localhost:4200")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<User> getUserByCredentials(@RequestBody LoginRequest loginRequest) throws Exception{
		Optional<User> user = userService.findByCredentials(loginRequest.getUsername(), loginRequest.getPassword());
		if (user.isPresent())
			return ResponseEntity.ok(user.get());
		else
			throw new Exception("not found");
	}
	
	@GetMapping("/test")
	public void test() throws Exception {
		User user = userService.findById(1);
		System.out.println(user);
	}

}
