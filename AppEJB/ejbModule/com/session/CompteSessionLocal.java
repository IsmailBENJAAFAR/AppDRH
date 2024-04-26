package com.session;

import java.util.List;


import javax.ejb.Local;

import com.entities.Compte;
import com.entities.Role;

@Local
public interface CompteSessionLocal {
	public void addCompte(Compte c);
	public void deleteCompte(int id);
	public void updateCompte(Compte c);
	public Compte getCompte(int id);
	public List<Compte> getAllComptes();
	public boolean isExist(String login,String password);
	public Role getRole(String login,String password);
	public List<Compte> getComptesParLogin(String r);
}
