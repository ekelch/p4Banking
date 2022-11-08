package com.revature.controllers;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.LoginRequest;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="localhost:4200")
public class UserController {

	private UserService userService;
	private UserRepository userRepo;
	
	public UserController(UserService userService, UserRepository userRepo) {
		this.userService = userService;
		this.userRepo = userRepo;
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
		Optional<User> user = userRepo.findById(6);
		System.out.println(user.get());
	}
	
	@PostMapping("/test")
	public void saveTestUser() {
		Account account = new Account();
		account.setBalance(new BigDecimal("3000.00"));
		
		User user = new User();
		user.setFirstName("Gandalf");
		user.setLastName("The Grey");
		user.setUsername("gandalf");
		user.setPassword("pass");
		user.setPermissionId(2);
		user.getAccounts().add(account);
		userRepo.save(user);
		
	}

}
