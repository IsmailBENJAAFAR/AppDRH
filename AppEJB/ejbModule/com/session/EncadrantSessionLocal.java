package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Encadrant;
import com.entities.Stagiere;

@Local
public interface EncadrantSessionLocal {
	public void addEncadrant(Encadrant e);
	public void deleteEncadrant(int id);
	public void updateEncadrant(Encadrant e);
	public Encadrant getEncadrant(int id);
	public List<Encadrant> getAllEncadrants();
	public List<Encadrant> getEncadrantsParNom(String r);
	public List<Encadrant> getEncadrantsParCin(String r);
	public void addEncadrantToDepartement(int id_encadrant,int id_departement);
	public int getEncadrantID(String cin);
}
