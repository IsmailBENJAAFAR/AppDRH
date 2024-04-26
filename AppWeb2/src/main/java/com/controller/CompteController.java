package com.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.entities.Compte;
import com.entities.Role;
import com.session.CompteSessionLocal;
@Stateless
@ManagedBean
@SessionScoped
public class CompteController {
	private int id;
	private boolean edit=false;
	private String login;
	private String password;
	private String role;
	private String recherche;
	@EJB
	private CompteSessionLocal compteLocal;
	
	private ArrayList<Compte> listeComptes;
	@PostConstruct
	public void initBean() {
		listeComptes = (ArrayList<Compte>) compteLocal.getAllComptes();
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
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<Compte> getListeComptes() {
		return this.listeComptes;
	}
	public void setListeComptes(ArrayList<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	
	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public Role attribuerRole(String r) {
		if (role.compareTo("ADMIN")==0) {
			return Role.ADMIN;
		}
		else if (role.compareTo("ADMINDRH")==0) {
			return Role.ADMINDRH;
		}
		else if (role.compareTo("CHEFDRH")==0) {
			return Role.CHEFDRH;
		}
		else {
			return Role.TEST;
		}
	}
	
	public CompteController(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public CompteController() {}
	public void save() {
		Compte c = new Compte(login,password,attribuerRole(role));
		if (!this.edit) {
			compteLocal.addCompte(c);
		}
		else {
			c.setId(this.id);
			compteLocal.updateCompte(c);
			this.edit = false;
		}
		reset();
		initBean();
	}
	public void update(int id) {
		this.id = id;
		this.edit = true;
		Compte c = compteLocal.getCompte(id);
		this.login = c.getLogin();
		this.password = c.getPassword();
		this.role = c.getRole().toString();
		initBean();
	}
	public void delete(int id) {
		compteLocal.deleteCompte(id);
		initBean();
	}
	private void reset() {
		this.login = null;
		this.password = null;
		this.role = null;
	}
	public void search() {
		setListeComptes((ArrayList<Compte>)compteLocal.getComptesParLogin(recherche));
		this.recherche = null ;
	}
}
