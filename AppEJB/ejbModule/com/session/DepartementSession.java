package com.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Departement;

@Stateless
@LocalBean
public class DepartementSession implements DepartementSessionLocal {
	@PersistenceContext
    private EntityManager em;
    public DepartementSession() {
        
    }

	@Override
	public void addDepartement(Departement d) {
		if(!isExist(d)) {
			em.persist(d);
		}
	}

	@Override
	public void deleteDepartement(int id) {
		Departement d = getDepartement(id);
		em.remove(d);
	}

	@Override
	public void updateDepartement(Departement d) {
		if(!isExist(d)) {
			em.merge(d);
		}
	}

	@Override
	public Departement getDepartement(int id) {
		Departement d = em.find(Departement.class, id);
		if (d == null) throw new RuntimeException("Departement introuvable");
		return d;
	}

	@Override
	public List<Departement> getAllDepartements() {
		Query q = em.createQuery("select d from Departement d");
		return q.getResultList();
	}
	
	private boolean isExist(Departement d) {
		ArrayList<Departement> liste = (ArrayList<Departement>) getAllDepartements();
		for (int i = 0; i < liste.size(); i++) {
			if (d.equals(liste.get(i))) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int getDepartementID(Departement d) {
		Query q = em.createNativeQuery("select id from departement where nom='"
				+d.getNom()+"'");
		return (int) q.getSingleResult();
	}

}
