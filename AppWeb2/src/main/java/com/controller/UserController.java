package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.entities.Role;
import com.session.CompteSessionLocal;

@ManagedBean
@ApplicationScoped
public class UserController {
	private String login;
	private String password;
	private Role role;
	@EJB
	private CompteSessionLocal compteLocal;
	public UserController() {
		
	}
	public UserController(String login, String password) {
		super();
		this.login = login;
		this.password = password;
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
	public String signin() {
		if (compteLocal.isExist(login,password)) {
			setRole(compteLocal.getRole(login, password));
			return "home.xhtml";
		}
		else {
			return "index.xhtml";
		}
	}
	public boolean isAdmin() {
		return role.toString().equalsIgnoreCase(Role.ADMIN.toString());
	}
	public boolean isChefDRH() {
		return role.toString().equalsIgnoreCase(Role.CHEFDRH.toString());
	}
	public boolean isAdminDRH() {
		return role.toString().equalsIgnoreCase(Role.ADMINDRH.toString());
	}
}
