package com.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.entities.Encadrant;
import com.entities.Etat;
import com.entities.Stage;
import com.entities.TypeStage;
import com.session.EncadrantSessionLocal;
import com.session.StageSessionLocal;

@ManagedBean
@SessionScoped
public class StageController {
	@EJB
	private StageSessionLocal stageLocal;
	@EJB
	private EncadrantSessionLocal encadrantLocal;
	
	private int id;
	private boolean edit=false;
	private String sujet;
	private Date dateDebut;
	private Date dateFin;
	private ArrayList<Stage> listeStages;
	private String division;
	private String idEncadrant;
	private String type;
	private String recherche;
	public StageController() {
		super();
		// TODO Auto-generated constructor stub
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
	public ArrayList<Stage> getListeStages() {
		return this.listeStages;
	}
	public void setListeStages(ArrayList<Stage> listeStages) {
		this.listeStages = listeStages;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getIdEncadrant() {
		return idEncadrant;
	}
	public void setIdEncadrant(String idEncadrant) {
		this.idEncadrant = idEncadrant;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRecherche() {
		return recherche;
	}
	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	@PostConstruct
	public void initBean() {
		listeStages = (ArrayList<Stage>) stageLocal.getAllStages();
	}
	public void save() {
		if (!this.edit) {
			Stage s = new Stage();
			s.setSujet(sujet);
			s.setDateDebut(dateDebut);
			s.setDateFin(dateFin);
			s.setDivision(division);
			if (type.equalsIgnoreCase(TypeStage.PFA.toString())) {
				s.setType(TypeStage.PFA);
			}
			else if (type.equalsIgnoreCase(TypeStage.PFE.toString())) {
				s.setType(TypeStage.PFE);
			}
			else if (type.equalsIgnoreCase(TypeStage.DOCTORAT.toString())) {
				s.setType(TypeStage.DOCTORAT);
			}
			s.setEtat(Etat.NONAFFECTER);
			Encadrant e = encadrantLocal.getEncadrant(Integer.parseInt(idEncadrant));
			e.setEtat(Etat.AFFECHTER);
			encadrantLocal.updateEncadrant(e); 
			s.setEncadrant(e);
			s.setDepartement(e.getDepartement());
			stageLocal.addStage(s);
		}
		else {
			Stage s = stageLocal.getStage(this.id);
			s.setSujet(sujet);
			s.setDateDebut(dateDebut);
			s.setDateFin(dateFin);
			s.setDivision(division);
			if (type.equalsIgnoreCase(TypeStage.PFA.toString())) {
				s.setType(TypeStage.PFA);
			}
			else if (type.equalsIgnoreCase(TypeStage.PFE.toString())) {
				s.setType(TypeStage.PFE);
			}
			else if (type.equalsIgnoreCase(TypeStage.DOCTORAT.toString())) {
				s.setType(TypeStage.DOCTORAT);
			}
			s.setEtat(Etat.NONAFFECTER);
			if(s.getEncadrant().getId()!=Integer.parseInt(idEncadrant)) {
				Encadrant e = s.getEncadrant();
				e.setEtat(Etat.NONAFFECTER);
				encadrantLocal.updateEncadrant(e);
				e = encadrantLocal.getEncadrant(Integer.parseInt(idEncadrant));
				e.setEtat(Etat.AFFECHTER);
				encadrantLocal.updateEncadrant(e);
				s.setEncadrant(e);
				s.setDepartement(e.getDepartement());
			}
			stageLocal.updateStage(s);
			this.edit = false;
		}
		reset();
		initBean();
	}
	public void update(int id) {
		this.id = id;
		this.edit = true;
		Stage s = stageLocal.getStage(id);
		this.sujet = s.getSujet();
		this.dateDebut = s.getDateDebut();
		this.dateFin = s.getDateFin();
		this.division = s.getDivision();
		this.idEncadrant = Integer.toString(s.getEncadrant().getId());
		this.type = s.getType().toString();
		initBean();
	}
	public void delete(int id) {
		if (stageLocal.getStage(id).getEtat().toString().equalsIgnoreCase(Etat.NONAFFECTER.toString())) {
			Encadrant e = stageLocal.getStage(id).getEncadrant();
			e.setEtat(Etat.NONAFFECTER);
			encadrantLocal.updateEncadrant(e);
			stageLocal.deleteStage(id);
		}
		initBean();
	}
	public void reset() {
		this.sujet = null;
		this.dateDebut = null;
		this.dateFin = null;
		this.division = null;
		this.idEncadrant = null;
		this.type = null;
	}
	public void search() {
		setListeStages((ArrayList<Stage>)stageLocal.getStagesParSujet(recherche));
		this.recherche = null ;
	}
}
