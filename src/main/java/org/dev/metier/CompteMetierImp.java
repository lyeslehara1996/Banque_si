package org.dev.metier;

import org.dev.dao.CompteRepository;
import org.dev.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImp  implements CompteMetier{
@Autowired
private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cp) {
		
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		
		return compteRepository.getOne(code);
	}

}
