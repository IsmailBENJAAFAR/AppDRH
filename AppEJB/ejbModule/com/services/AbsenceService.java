package com.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entities.Absence;
import com.session.AbsenceSessionLocal;

@Stateless
@WebService
public class AbsenceService {
	@EJB
	private AbsenceSessionLocal absenceSessionLocal;
	
	public AbsenceService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	public void save(Absence a) {
		absenceSessionLocal.addAbsence(a);;
	}
	@WebMethod
	public void delete(int id) {
		absenceSessionLocal.deleteAbsence(id);
	}
	@WebMethod
	public void update(Absence a) {
		absenceSessionLocal.updateAbsence(a);
	}
	@WebMethod
	public Absence get(int id) {
		return absenceSessionLocal.getAbsence(id);
	}
	@WebMethod
	public List<Absence> getAll(){
		return absenceSessionLocal.getAllAbsences();
	}
	
}
