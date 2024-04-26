package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Departement;


@Local
public interface DepartementSessionLocal {
	public void addDepartement(Departement d);
	public void deleteDepartement(int id);
	public void updateDepartement(Departement d);
	public Departement getDepartement(int id);
	public List<Departement> getAllDepartements();
	public int getDepartementID(Departement d);
}
