package com.revature.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public class User{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int userId;
		String username;
		String password;
		String firstName;
		String lastName;
		int permissionId;
	
}
