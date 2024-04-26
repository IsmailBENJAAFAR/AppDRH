package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Encadrant;
import com.entities.Stage;

@Local
public interface StageSessionLocal {
	public void addStage(Stage s);
	public void deleteStage(int id);
	public void updateStage(Stage s);
	public Stage getStage(int id);
	public List<Stage> getAllStages();
	public void addStageToEncadrant(int id_stage,int id_encadrant);
	public int getStageID(String sujet);
	public List<Stage> getStagesParSujet(String r);
}
