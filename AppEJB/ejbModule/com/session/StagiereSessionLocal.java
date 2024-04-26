package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Stagiere;

@Local
public interface StagiereSessionLocal {
	public void addStagiere(Stagiere s);
	public void deleteStagiere(int id);
	public void updateStagiere(Stagiere s);
	public Stagiere getStagiere(int id);
	public List<Stagiere> getAllStagieres();
	public List<Stagiere> getStagieresParNom(String r);
	public List<Stagiere> getStagieresParCin(String r);
	public void assignStagiereToStage(int id_stagiere,int id_stage);
	public int getStagiereID(String cin);
}
