package com.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entities.Encadrant;
import com.session.EncadrantSessionLocal;

@Stateless
@WebService
public class EncadrantService {
	@EJB
	private EncadrantSessionLocal encadrantSessionLocal;

	public EncadrantService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	public void save(Encadrant e) {
		encadrantSessionLocal.addEncadrant(e);
	}
	@WebMethod
	public void delete(int id) {
		encadrantSessionLocal.deleteEncadrant(id);
	}
	@WebMethod
	public void update(Encadrant e) {
		encadrantSessionLocal.updateEncadrant(e);
	}
	@WebMethod
	public Encadrant get(int id) {
		return encadrantSessionLocal.getEncadrant(id);
	}
	@WebMethod
	public List<Encadrant> getAll(){
		return encadrantSessionLocal.getAllEncadrants();
	}
}
