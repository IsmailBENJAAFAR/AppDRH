package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Compte")
public class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compte")
	private int id;
	@Column(name = "login_compte",unique = true)
	private String login;
	@Column(name = "password_compte")
	private String password;
	@Column(name = "role_compte")
	private Role role;
	public Compte() {
		
	}
	
	public Compte(String login, String password, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public int getId() {
		return id;
	}

	public boolean equals(Compte c) {
		return this.getLogin().equalsIgnoreCase(c.getLogin()) && this.getPassword().compareTo(c.getPassword())==0;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
