package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Absence")
public class Absence implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="date_a")
	@Temporal(TemporalType.DATE)
	private Date dateA;
	@ManyToOne
	@JoinColumn(name="id_stagiere",referencedColumnName = "id")
	private Stagiere stagiere;
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Absence(Date dateA, Stagiere stagiere) {
		super();
		this.dateA = dateA;
		this.stagiere = stagiere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateA() {
		return dateA;
	}
	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}
	public Stagiere getStagiere() {
		return stagiere;
	}
	public void setStagiere(Stagiere stagiere) {
		this.stagiere = stagiere;
	}
	
}
