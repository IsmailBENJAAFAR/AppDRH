package com.controller;

import java.util.ArrayList;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.entities.Etat;
import com.entities.Stage;
import com.entities.Stagiere;
import com.session.StageSessionLocal;
import com.session.StagiereSessionLocal;

@ManagedBean
@SessionScoped
public class StagiereController {
	@EJB
	private StagiereSessionLocal stagiereLocal;
	@EJB
	private StageSessionLocal stageLocal;
	
	private int id;
	private boolean edit = false;
	private String cin;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String etablissement;
	private String filiere;
	private String adresse;
	private String email;
	private String telephone;
	private String idStage;
	private ArrayList<Stagiere> listeStagieres;
	private String recherche;
	public StagiereController() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	
	
	public String getIdStage() {
		return idStage;
	}
	public void setIdStage(String idStage) {
		this.idStage = idStage;
	}
	public ArrayList<Stagiere> getListeStagieres() {
		return this.listeStagieres;
	}
	public void setListeStagieres(ArrayList<Stagiere> listeStagieres) {
		this.listeStagieres = listeStagieres;
	}
	
	public String getRecherche() {
		return recherche;
	}
	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	@PostConstruct
	public void initBean() {
		this.listeStagieres = (ArrayList<Stagiere>) stagiereLocal.getAllStagieres();
	}
	public void save() {
		if (!this.edit) {
			Stagiere s = new Stagiere();
			s.setCin(cin);
			s.setNom(nom);
			s.setPrenom(prenom);
			s.setDateNaissance(dateNaissance);
			s.setEtablissement(etablissement);
			s.setFiliere(filiere);
			s.setAdresse(adresse);
			s.setEmail(email);
			s.setTelephone(telephone);
			Stage ss = stageLocal.getStage(Integer.parseInt(idStage));
			ss.setEtat(Etat.AFFECHTER);
			stageLocal.updateStage(ss);
			s.setStage(ss);
			stagiereLocal.addStagiere(s);
		}
		else {
			Stagiere s = stagiereLocal.getStagiere(this.id);
			s.setCin(cin);
			s.setNom(nom);
			s.setPrenom(prenom);
			s.setDateNaissance(dateNaissance);
			s.setEtablissement(etablissement);
			s.setFiliere(filiere);
			s.setAdresse(adresse);
			s.setEmail(email);
			s.setTelephone(telephone);
			if (s.getStage().getId()!=Integer.parseInt(idStage)) {
				Stage ss = s.getStage();
				ss.setEtat(Etat.NONAFFECTER);
				stageLocal.updateStage(ss);
				ss = stageLocal.getStage(Integer.parseInt(idStage));
				ss.setEtat(Etat.AFFECHTER);
				stageLocal.updateStage(ss);
				s.setStage(ss);
			}
			stagiereLocal.updateStagiere(s);
			this.edit = false;
		}
		reset();
		initBean();
	}
	public void delete(int id) {
		Stage s = stagiereLocal.getStagiere(id).getStage();
		s.setEtat(Etat.NONAFFECTER);
		stageLocal.updateStage(s);
		stagiereLocal.deleteStagiere(id);
		initBean();
	}
	public void update(int id) {
		this.id = id;
		this.edit = true;
		Stagiere s = stagiereLocal.getStagiere(id);
		this.cin = s.getCin();
		this.nom = s.getNom();
		this.prenom = s.getPrenom();
		this.dateNaissance = s.getDateNaissance();
		this.etablissement = s.getEtablissement();
		this.filiere = s.getFiliere();
		this.adresse = s.getAdresse();
		this.email = s.getEmail();
		this.telephone = s.getTelephone();
		this.idStage = Integer.toString(s.getStage().getId());
	}
	public void reset() {
		this.cin = null;
		this.nom = null;
		this.prenom = null;
		this.dateNaissance = null;
		this.etablissement = null;
		this.filiere = null;
		this.adresse = null;
		this.email = null;
		this.telephone = null;
		this.idStage = null;
	}
	public void search() {
		setListeStagieres((ArrayList<Stagiere>)stagiereLocal.getStagieresParNom(recherche));
		this.recherche = null ;
	}
}
