package com.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entities.Stagiere;
import com.session.StagiereSessionLocal;

@Stateless
@WebService
public class StagiereService {
	@EJB
	private StagiereSessionLocal stagiereSessionLocal;

	public StagiereService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	public void save(Stagiere s) {
		stagiereSessionLocal.addStagiere(s);
	}
	@WebMethod
	public void delete(int id) {
		stagiereSessionLocal.deleteStagiere(id);
	}
	@WebMethod
	public void update(Stagiere s) {
		stagiereSessionLocal.updateStagiere(s);
	}
	@WebMethod
	public Stagiere get(int id) {
		return stagiereSessionLocal.getStagiere(id);
	}
	@WebMethod
	public List<Stagiere> getAll(){
		return stagiereSessionLocal.getAllStagieres();
	}
}
