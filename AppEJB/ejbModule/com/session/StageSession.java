package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Encadrant;
import com.entities.Stage;


@Stateless
@LocalBean
public class StageSession implements StageSessionLocal {
	@PersistenceContext
	private EntityManager em;
    public StageSession() {
        
    }
	@Override
	public void addStage(Stage s) {
		em.persist(s);
	}
	@Override
	public void deleteStage(int id) {
		Stage s = getStage(id);
		em.remove(s);
	}
	@Override
	public void updateStage(Stage s) {
		em.merge(s);
	}
	@Override
	public Stage getStage(int id) {
		Stage s = em.find(Stage.class, id);
		if (s == null) throw new RuntimeException("Satge introuvable");
		return s;
	}
	@Override
	public List<Stage> getAllStages() {
		Query q = em.createQuery("select s from Stage s");
		return q.getResultList();
	}
	@Override
	public void addStageToEncadrant(int id_stage, int id_encadrant) {
		Stage s = em.find(Stage.class, id_stage);
		Encadrant e = em.find(Encadrant.class,id_encadrant);
		s.setEncadrant(e);
		e.setStage(s);
		s.setDepartement(e.getDepartement());
		
	}
	@Override
	public int getStageID(String sujet) {
		Query q = em.createQuery("select id from Stage s where s.sujet=:sujet").setParameter("sujet", "'"+sujet+"'");
		return (int) q.getSingleResult();
	}
	@Override
	public List<Stage> getStagesParSujet(String r) {
		Query q = em.createQuery("select s from Stage s where s.sujet like :r").setParameter("r", r+"%");
		return q.getResultList();
	}

}
