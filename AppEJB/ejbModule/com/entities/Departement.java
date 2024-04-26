package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Departement")
public class Departement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nom",unique = true)
	private String nom;
	@OneToMany(mappedBy = "departement")
	private List<Encadrant> encadrants;
	@OneToMany(mappedBy = "departement")
	private List<Stage> stage;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String nom) {
		super();
		this.nom = nom;
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
	public boolean equals(Departement d) {
		return this.nom.equalsIgnoreCase(d.getNom());
	}
	@XmlTransient
	public List<Encadrant> getEncadrants() {
		return encadrants;
	}
	public void setEncadrants(List<Encadrant> encadrants) {
		this.encadrants = encadrants;
	}
	@XmlTransient
	public List<Stage> getStage() {
		return stage;
	}
	public void setStage(List<Stage> stage) {
		this.stage = stage;
	}
	
	
}
