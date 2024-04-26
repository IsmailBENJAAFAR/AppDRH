package com.services;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entities.Compte;
import com.session.CompteSessionLocal;
@Stateless
@WebService
public class CompteService {
	@EJB
	private CompteSessionLocal compteSessionLocal;
	
	public CompteService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	public void save(Compte c) {
		compteSessionLocal.addCompte(c);
	}
	@WebMethod
	public void update(Compte c) {
		compteSessionLocal.updateCompte(c);
	}
	@WebMethod
	public void delete(int id) {
		compteSessionLocal.deleteCompte(id);
	}
	@WebMethod
	public List<Compte> getAll(){
		return compteSessionLocal.getAllComptes();
	}
	@WebMethod
	public Compte get(int id) {
		return compteSessionLocal.getCompte(id);
	}
}
