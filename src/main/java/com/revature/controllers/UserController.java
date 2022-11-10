package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.LoginRequest;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins={"http://localhost:8080", "http://localhost:4200"}, allowCredentials="true")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody LoginRequest loginRequest, HttpSession session) throws Exception{
		User user = userService.findByCredentials(loginRequest.getUsername(), loginRequest.getPassword());
		session.setAttribute("user", user);
		return ResponseEntity.ok(user);
		
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) throws UserNotFoundException {
		User user = userService.findById(id);		
		return ResponseEntity.ok(user);
	}

}
