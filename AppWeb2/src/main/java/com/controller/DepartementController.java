package com.controller;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.entities.Departement;
import com.session.DepartementSessionLocal;

@ManagedBean
@RequestScoped
public class DepartementController {
	@EJB
	private DepartementSessionLocal departementLocal;
	
	private ArrayList<Departement> listeDepartements;

	public ArrayList<Departement> getListeDepartements() {
		return (ArrayList<Departement>) departementLocal.getAllDepartements();
	}

	public void setListeDepartements(ArrayList<Departement> listeDepartements) {
		this.listeDepartements = listeDepartements;
	}

	public DepartementController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
