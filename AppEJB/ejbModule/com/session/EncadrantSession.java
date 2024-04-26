package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Departement;
import com.entities.Encadrant;


@Stateless
@LocalBean
public class EncadrantSession implements EncadrantSessionLocal {
	@PersistenceContext
	private EntityManager em;
	
    public EncadrantSession() {
        
    }

	@Override
	public void addEncadrant(Encadrant e) {
		em.persist(e);
	}

	@Override
	public void deleteEncadrant(int id) {
		Encadrant e = getEncadrant(id);
		em.remove(e);
	}

	@Override
	public void updateEncadrant(Encadrant e) {
		em.merge(e);
	}

	@Override
	public Encadrant getEncadrant(int id) {
		Encadrant e = em.find(Encadrant.class, id);
		if (e == null) throw new RuntimeException("Encadrant introuvable");
		return e;
	}

	@Override
	public List<Encadrant> getAllEncadrants() {
		Query q = em.createQuery("select e from Encadrant e");
		return q.getResultList();
	}

	@Override
	public List<Encadrant> getEncadrantsParNom(String r) {
		Query q = em.createQuery("select e from Encadrant e where e.nom like :r").setParameter("r", r+"%");
		return q.getResultList();
	}

	@Override
	public List<Encadrant> getEncadrantsParCin(String r) {
		Query q = em.createQuery("select e from Encadrant e where e.cin like :r").setParameter("r", r+"%");
		return q.getResultList();
	}

	@Override
	public void addEncadrantToDepartement(int id_encadrant, int id_departement) {
		Encadrant e = em.find(Encadrant.class, id_encadrant);
		Departement d = em.find(Departement.class, id_departement);
		e.setDepartement(d);
		d.getEncadrants().add(e);
	}

	@Override
	public int getEncadrantID(String cin) {
		Query q = em.createQuery("select id from Encadrant e where e.cin=:cin").setParameter("cin", "'"+cin+"'");
		return (int) q.getSingleResult();
	}

}
