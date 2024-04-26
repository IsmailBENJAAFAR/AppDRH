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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Stage")
public class Stage implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="sujet",unique = true)
	private String sujet;
	@Column(name="date_debut")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column(name="date_fin")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column(name="division")
	private String division;
	@Column(name="type")
	private TypeStage type;
	@Column(name="etat")
	private Etat etat;
	@OneToMany(mappedBy = "stage")
	private List<Stagiere> stagieres;
	@ManyToOne
	@JoinColumn(name="id_departement")
	private Departement departement;
	@OneToOne
	@JoinColumn(name="id_encadrant",unique = true)
	private Encadrant encadrant;
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stage(String sujet, Date dateDebut, Date dateFin, String division, TypeStage type, Etat etat) {
		super();
		this.sujet = sujet;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.division = division;
		this.type = type;
		this.etat = etat;
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
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public TypeStage getType() {
		return type;
	}
	public void setType(TypeStage type) {
		this.type = type;
	}
	@XmlTransient
	public List<Stagiere> getStagieres() {
		return stagieres;
	}

	public void setStagieres(List<Stagiere> stagieres) {
		this.stagieres = stagieres;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Encadrant getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}
	
}
