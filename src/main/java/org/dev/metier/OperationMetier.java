package org.dev.metier;

public interface OperationMetier {

	public boolean verser(String code,double montant,long codeEmp);
	public boolean retirer(String code,double montant,long codeEmp);
	public boolean virement(String cpte1,String cpte2,double montant,long codeEmp);
	public PageOperation getOperation(String Code,int page,int size);
	
}
