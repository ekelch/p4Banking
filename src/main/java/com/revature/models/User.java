package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Table(name="users")
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public class User{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer id;
		@Column(name="username")
		String username;
		@Column(name="password")
		String password;
		@Column(name="first_name")
		String firstName;
		@Column(name="last_name")
		String lastName;
		@Column(name="permission_id")
		int permissionId;
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(
				name = "bridge",
				joinColumns = { @JoinColumn(name="user_id")},
				inverseJoinColumns = { @JoinColumn(name="account_id") }
		)
		private Set<Account> accounts;
	
}
