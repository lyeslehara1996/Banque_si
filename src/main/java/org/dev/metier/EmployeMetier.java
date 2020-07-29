package org.dev.metier;

import java.util.List;

import org.dev.entities.Employe;

public interface EmployeMetier {

	public Employe saveEmploye(Employe e);
	public List<Employe> listEmployes();
}
