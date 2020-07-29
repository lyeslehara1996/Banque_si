package org.dev.services;

import org.dev.entities.Compte;
import org.dev.metier.CompteMetier;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {
	
		@Autowired
		private CompteMetier compteMetier;
		
		@RequestMapping(value = "/comptes",method = RequestMethod.POST)
		public Compte saveCompte(@RequestBody Compte cp) {
			return compteMetier.saveCompte(cp);
		}
		@RequestMapping(value = "/comptes/{code}",method = RequestMethod.GET)
//		@RequestMapping(value = "/comptes/{code}",method = RequestMethod.GET)
		public @ResponseBody Compte getCompte(@PathVariable String code) throws QueryException {
			return compteMetier.getCompte(code);
		}
	
		
	
}
