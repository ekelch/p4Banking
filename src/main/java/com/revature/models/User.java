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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity
	@Table(name="users")
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
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
		@JsonManagedReference
		private Set<Account> accounts = new HashSet<Account>();
	
}
