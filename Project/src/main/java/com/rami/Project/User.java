package com.rami.Project;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "userName")
	@NotEmpty(message= "Please enter name")
	private String userName;
	@Column(name = "password")
	@NotEmpty(message= "Please enter Password")
	@Size(min=3, max=50)
	private String password;
	@Column(name = "email")
	@Email(message="Invalid email")
	private String email;
	@Column(name = "roles")
	@NotEmpty(message= "Please enter role")
	private String roles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userName, String password, String email, String roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
