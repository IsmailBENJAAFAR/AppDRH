package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Absence;

@Local
public interface AbsenceSessionLocal {
	public void addAbsence(Absence a);
	public void deleteAbsence(int id);
	public void updateAbsence(Absence a);
	public Absence getAbsence(int id);
	public List<Absence> getAllAbsences();
}
