package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.TransactionDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.services.AccountService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins={"http://localhost:8080", "http://localhost:4200"}, allowCredentials="true")
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PutMapping("/deposit")
	public ResponseEntity<Account> deposit(@RequestBody TransactionDTO depositDTO) throws UserNotFoundException {
		System.out.println(depositDTO);
		Account account = accountService.findById(depositDTO.getId());
		Account updatedAccount = accountService.deposit(account, depositDTO.getAmount());
		return ResponseEntity.ok(updatedAccount);
	}
	
	@PutMapping("/withdraw")
	public ResponseEntity<Account> withdraw(@RequestBody TransactionDTO depositDTO) throws UserNotFoundException {
		System.out.println(depositDTO);
		Account account = accountService.findById(depositDTO.getId());
		Account updatedAccount = accountService.withdraw(account, depositDTO.getAmount());
		return ResponseEntity.ok(updatedAccount);
	}
	
}
