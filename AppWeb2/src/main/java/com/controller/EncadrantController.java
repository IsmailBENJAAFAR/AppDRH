package com.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.entities.Departement;
import com.entities.Encadrant;
import com.entities.Etat;
import com.session.DepartementSessionLocal;
import com.session.EncadrantSessionLocal;
@Stateless
@ManagedBean
@SessionScoped
public class EncadrantController {
	@EJB
	private EncadrantSessionLocal encadrantLocal;
	@EJB
	private DepartementSessionLocal departementLocal;
	
	private int id;
	private boolean edit=false;
	private String cin;
	private String nom;
	private String prenom;
	private String idDepartement;
	private ArrayList<Encadrant> listeEncadrants;
	private String recherche;
	public EncadrantController() {
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

	public String getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(String idDepartement) {
		this.idDepartement = idDepartement;
	}

	public ArrayList<Encadrant> getListeEncadrants() {
		return this.listeEncadrants;
	}

	public void setListeEncadrants(ArrayList<Encadrant> listeEncadrants) {
		this.listeEncadrants = listeEncadrants;
	}
	
	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	@PostConstruct
	public void initBean() {
		this.listeEncadrants = (ArrayList<Encadrant>) encadrantLocal.getAllEncadrants();
	}
	public void save() {
		if (!this.edit) {
			Encadrant e = new Encadrant();
			e.setCin(cin);
			e.setEtat(Etat.NONAFFECTER);
			e.setNom(nom);
			e.setPrenom(prenom);
			Departement d = departementLocal.getDepartement(Integer.parseInt(idDepartement));
			e.setDepartement(d);
			encadrantLocal.addEncadrant(e);
		}
		else {
			Encadrant e = encadrantLocal.getEncadrant(this.id);
			e.setCin(cin);
			e.setNom(nom);
			e.setPrenom(prenom);
			Departement d = departementLocal.getDepartement(Integer.parseInt(idDepartement));
			e.setDepartement(d);
			encadrantLocal.updateEncadrant(e);
			this.edit = false;
		}
		reset();
		initBean();
		
	}
	public void delete(int id) {
		Encadrant e = encadrantLocal.getEncadrant(id);
		if (e.getEtat().toString().equalsIgnoreCase(Etat.NONAFFECTER.toString())) {
			encadrantLocal.deleteEncadrant(id);
		}
		initBean();
	}
	public void update(int id) {
		this.id = id;
		this.edit = true;
		Encadrant e = encadrantLocal.getEncadrant(id);
		this.cin = e.getCin();
		this.nom = e.getNom();
		this.prenom = e.getPrenom();
		this.idDepartement = Integer.toString(e.getDepartement().getId());
		initBean();
	}
	public void reset() {
		this.cin = null;
		this.nom = null;
		this.prenom = null;
		this.idDepartement = null;
	}
	public void search() {
		setListeEncadrants((ArrayList<Encadrant>)encadrantLocal.getEncadrantsParNom(recherche));
		this.recherche = null ;
	}
}
