package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@Email(message = "Please provide valid email address")
	@Column(name="email")
	private String email; 
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public User() {
		
	}
	
	
}
