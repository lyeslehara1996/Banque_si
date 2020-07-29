package org.dev.metier;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.dev.dao.CompteRepository;
import org.dev.dao.EmployeRepository;
import org.dev.dao.OperationRepository;
import org.dev.entities.Compte;
import org.dev.entities.Employe;
import org.dev.entities.Operation;
import org.dev.entities.Retrait;
import org.dev.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImp implements OperationMetier {
@Autowired
private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Override
	@Transactional
	public boolean verser(String code, double montant, long codeEmp) {
		// TODO Auto-generated method stub
		Compte cp =compteRepository.getOne(code);
	if(cp == null) new RuntimeException("ce compte n'existe pas");
		Employe e =employeRepository.getOne(codeEmp);
		Operation o =new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, long codeEmp) {
		
		Compte cp =compteRepository.getOne(code);
		Employe e =employeRepository.getOne(codeEmp);
		if(cp.getSolde()<montant)throw new RuntimeException("solde inssufisant");
		Operation o =new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
		
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, long codeEmp) {
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperation(String Code, int page, int size) {
//		  Page<Operation> ops =operationRepository.getOperation(CodeCompte, new PageRequest(page, size));
		
		Compte cp =compteRepository.getOne(Code);
		Page<Operation> ops2 =operationRepository.findByCompte(cp, new PageRequest(page, size));
		  PageOperation pOp =new PageOperation();
		  pOp.setOperations(ops2.getContent());
		  pOp.setNombreOperations(ops2.getNumberOfElements());
		  pOp.setPage(ops2.getNumber());
		  pOp.setTotalpages(ops2.getTotalPages());
		  pOp.setTotalOperation((int)ops2.getTotalElements());
		  
		return pOp;
	}



}
