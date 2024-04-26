package com.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entities.Departement;
import com.session.DepartementSessionLocal;
@Stateless
@WebService
public class DepartementService {
	@EJB
	private DepartementSessionLocal departementSessionLocal;
	
	public DepartementService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	public void save(Departement d) {
		departementSessionLocal.addDepartement(d);
	}
	@WebMethod
	public void delete(int id) {
		departementSessionLocal.deleteDepartement(id);
	}
	@WebMethod
	public void update(Departement d) {
		departementSessionLocal.updateDepartement(d);
	}
	@WebMethod
	public Departement get(int id) {
		return departementSessionLocal.getDepartement(id);
	}
	@WebMethod
	public List<Departement> getAll(){
		return departementSessionLocal.getAllDepartements();
	}
	@WebMethod
	public int getID(String nom) {
		Departement d = new Departement(nom);
		return departementSessionLocal.getDepartementID(d);
	}
}
