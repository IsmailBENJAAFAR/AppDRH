package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Absence;

@Stateless
@LocalBean
public class AbsenceSession implements AbsenceSessionLocal {

	@PersistenceContext
	private EntityManager em;
    public AbsenceSession() {
        
    }
	@Override
	public void addAbsence(Absence a) {
		em.persist(a);
	}
	@Override
	public void deleteAbsence(int id) {
		Absence a = getAbsence(id);
		em.remove(a);
	}
	@Override
	public void updateAbsence(Absence a) {
		em.merge(a);
	}
	@Override
	public Absence getAbsence(int id) {
		Absence a = em.find(Absence.class, id);
		if (a == null) throw new RuntimeException("Absence introuvable");
		return a;
	}
	@Override
	public List<Absence> getAllAbsences() {
		Query q = em.createQuery("select a from Absence a");
		return q.getResultList();
	}

}
