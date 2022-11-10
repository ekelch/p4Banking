package com.revature.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.repositories.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account findById(int id) throws UserNotFoundException {
		Optional<Account> account = accountRepository.findById(id);
		if (account.isPresent())
			return account.get();
		else
			throw new UserNotFoundException("Account not found");
		}

	public Account deposit(Account account, BigDecimal depositAmount) {
		BigDecimal startingBalance = account.getBalance();
		BigDecimal updatedBalance = startingBalance.add(depositAmount);
		account.setBalance(updatedBalance);
		accountRepository.save(account);
		return account;
	}

	public Account withdraw(Account account, BigDecimal depositAmount) {
		BigDecimal startingBalance = account.getBalance();
		BigDecimal updatedBalance = startingBalance.subtract(depositAmount);
		account.setBalance(updatedBalance);
		accountRepository.save(account);
		return account;
	}
}
