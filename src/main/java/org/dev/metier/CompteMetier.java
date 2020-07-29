package org.dev.metier;

import org.dev.entities.Compte;

public interface CompteMetier {
	
	public Compte  saveCompte(Compte cp);
	public Compte getCompte(String code);
	
	
}
