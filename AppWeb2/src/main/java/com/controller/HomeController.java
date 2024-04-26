package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.session.DepartementSessionLocal;
import com.session.EncadrantSessionLocal;
import com.session.StageSessionLocal;
import com.session.StagiereSessionLocal;

@ManagedBean
@RequestScoped
public class HomeController {
	@EJB
	private StageSessionLocal stageLocal;
	@EJB
	private StagiereSessionLocal stagiereLocal;
	@EJB
	private EncadrantSessionLocal encadrantLocal;
	
	private int nombreStage;
	private int nombreStagiere;
	private int nombreEncadrant;
	
	public HomeController() {}

	public int getNombreStage() {
		return stageLocal.getAllStages().size();
	}

	public void setNombreStage(int nombreStage) {
		this.nombreStage = nombreStage;
	}

	public int getNombreStagiere() {
		return stagiereLocal.getAllStagieres().size();
	}

	public void setNombreStagiere(int nombreStagiere) {
		this.nombreStagiere = nombreStagiere;
	}

	public int getNombreEncadrant() {
		return encadrantLocal.getAllEncadrants().size();
	}

	public void setNombreEncadrant(int nombreEncadrant) {
		this.nombreEncadrant = nombreEncadrant;
	}
	
	
	
}
