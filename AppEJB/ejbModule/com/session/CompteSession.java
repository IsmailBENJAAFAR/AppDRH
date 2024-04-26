package com.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Compte;
import com.entities.Encadrant;
import com.entities.Role;


@Stateless
@LocalBean
public class CompteSession implements CompteSessionLocal {
	
	@PersistenceContext
    private EntityManager em;
	
    public CompteSession() {
        
    }

	@Override
	public void addCompte(Compte c) {
		if (!isExist(c.getLogin(),c.getPassword())) {
			em.persist(c);
		}
	}

	@Override
	public void deleteCompte(int id) {
		em.remove(em.find(Compte.class, id));
	}

	@Override
	public void updateCompte(Compte c) {
		em.merge(c);
	}

	@Override
	public Compte getCompte(int id) {
		Compte c = em.find(Compte.class, id);
		return c;
	}

	@Override
	public List<Compte> getAllComptes() {
		Query q = em.createQuery("select c from Compte c");
		return q.getResultList();
	}

	@Override
	public boolean isExist(String login,String password) {
		Compte c = new Compte(login,password,Role.TEST);
		ArrayList<Compte> list = (ArrayList<Compte>) getAllComptes();
		for (int i=0;i<list.size();i++) {
			if (c.equals(list.get(i))) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Role getRole(String login,String password) {
		Compte c = new Compte(login,password,Role.TEST);
		ArrayList<Compte> list = (ArrayList<Compte>) getAllComptes();
		for (int i=0;i<list.size();i++) {
			if (c.equals(list.get(i))) {
				return list.get(i).getRole();
			}
		}
		return Role.TEST;
	}

	@Override
	public List<Compte> getComptesParLogin(String r) {
		Query q = em.createQuery("select c from Compte c where c.login like :r").setParameter("r", r+"%");
		return q.getResultList();
	}

}
