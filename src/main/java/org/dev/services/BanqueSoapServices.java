package org.dev.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.dev.dao.CompteRepository;
import org.dev.dao.OperationRepository;
import org.dev.entities.Compte;
import org.dev.metier.CompteMetier;
import org.dev.metier.OperationMetier;
import org.dev.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class BanqueSoapServices {
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public Compte getCompte(@WebParam(name = "code") String code) {
		return compteMetier.getCompte(code);
	}
	@WebMethod
	public boolean verser(@WebParam(name = "code") String code,@WebParam(name = "montant") double montant,@WebParam(name = "codeEmp") long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	@WebMethod
	public boolean retirer(@WebParam(name = "code")  String code,@WebParam(name = "montant")  double montant,@WebParam(name = "codeEmp")  long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
	@WebMethod
	public boolean virement(@WebParam(name = "cpte1")  String cpte1,@WebParam(name = "cpte2")  String cpte2,@WebParam(name = "montant")  double montant,@WebParam(name = "codeEmp")  long codeEmp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}
	@WebMethod
	public PageOperation getOperation(@WebParam(name = "code") String Code,@WebParam(name = "page")  int page,@WebParam(name = "size")  int size) {
		return operationMetier.getOperation(Code, page, size);
	}
	
}
