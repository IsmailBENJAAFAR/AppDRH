package com.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.entities.Stage;
import com.session.StageSessionLocal;

@Stateless
@WebService
public class StageService {
	@EJB
	private StageSessionLocal stageSessionLocal;

	public StageService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	public void save(Stage s) {
		stageSessionLocal.addStage(s);
	}
	@WebMethod
	public void delete(int id) {
		stageSessionLocal.deleteStage(id);
	}
	@WebMethod
	public void update(Stage s) {
		stageSessionLocal.updateStage(s);
	}
	@WebMethod
	public Stage get(int id) {
		return stageSessionLocal.getStage(id);
	}
	@WebMethod
	public List<Stage> getAll(){
		return stageSessionLocal.getAllStages();
	}
}
