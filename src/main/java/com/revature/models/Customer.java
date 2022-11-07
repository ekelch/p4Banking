package com.revature.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	String username;
	String password;
	String firstName;
	String lastName;
	int permissionId;

}
