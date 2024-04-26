package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Stage;
import com.entities.Stagiere;


@Stateless
@LocalBean
public class StagiereSession implements StagiereSessionLocal {
	@PersistenceContext
	private EntityManager em;
    public StagiereSession() {
        
    }
	@Override
	public void addStagiere(Stagiere s) {
		em.persist(s);
		
	}
	@Override
	public void deleteStagiere(int id) {
		Stagiere s = getStagiere(id);
		em.remove(s);
	}
	@Override
	public void updateStagiere(Stagiere s) {
		em.merge(s);
	}
	@Override
	public Stagiere getStagiere(int id) {
		Stagiere s = em.find(Stagiere.class, id);
		if (s == null) throw new RuntimeException("Stagiere introuvable");
		return s;
	}
	@Override
	public List<Stagiere> getAllStagieres() {
		Query q = em.createQuery("select s from Stagiere s");
		return q.getResultList();
	}
	@Override
	public List<Stagiere> getStagieresParNom(String r) {
		Query q = em.createQuery("select s from Stagiere s where s.nom like :r").setParameter("r", r+"%");
		return q.getResultList();
	}
	@Override
	public List<Stagiere> getStagieresParCin(String r) {
		Query q = em.createQuery("select s from Stagiere s where s.cin like :r").setParameter("r", r+"%");
		return q.getResultList();
	}
	@Override
	public void assignStagiereToStage(int id_stagiere,int id_stage) {
		Stagiere stagiere = em.find(Stagiere.class, id_stagiere);
		Stage stage = em.find(Stage.class, id_stage);
		stagiere.setStage(stage);
		stage.getStagieres().add(stagiere);
	}
	@Override
	public int getStagiereID(String cin) {
		Query q = em.createQuery("select id from Stagiere s where s.cin=:cin").setParameter("cin", "'"+cin+"'");
		return (int) q.getSingleResult();
	}

}
