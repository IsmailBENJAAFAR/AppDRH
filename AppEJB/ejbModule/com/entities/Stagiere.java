package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name="Stagiere")
public class Stagiere implements Serializable {
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
	@Column(name="etablissement")
	private String etablissement;
	@Column(name="filiere")
	private String filiere;
	@Column(name="adresse")
	private String adresse;
	@Column(name="email")
	private String email;
	@Column(name="telephone")
	private String telephone;
	@Column(name="dateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@ManyToOne
	@JoinColumn(name="id_stage")
	private Stage stage;
	@OneToMany(mappedBy = "stagiere")
	private List<Absence> absenses;
	public Stagiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stagiere(String cin, String nom, String prenom, String etablissement, String filiere, String adresse,
			String email, String telephone, Date dateNaissance) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.etablissement = etablissement;
		this.filiere = filiere;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	@XmlTransient
	public List<Absence> getAbsenses() {
		return absenses;
	}
	public void setAbsenses(List<Absence> absenses) {
		this.absenses = absenses;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
