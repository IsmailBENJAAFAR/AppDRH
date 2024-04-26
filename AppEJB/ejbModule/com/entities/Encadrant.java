package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Encadrant")
public class Encadrant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="cin",unique = true)
	private String cin;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="etat")
	private Etat etat;
	@ManyToOne
	@JoinColumn(name="id_departement")
	private Departement departement;
	@OneToOne(mappedBy = "encadrant")
	private Stage stage;
	public Encadrant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Encadrant(String cin, String nom, String prenom, Etat etat) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
	}
	
	public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	public Etat getEtat() {
		return etat;
	}



	public void setEtat(Etat etat) {
		this.etat = etat;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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



	public Departement getDepartement() {
		return departement;
	}



	public void setDepartement(Departement departement) {
		this.departement = departement;
	}



	public Stage getStage() {
		return stage;
	}



	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
