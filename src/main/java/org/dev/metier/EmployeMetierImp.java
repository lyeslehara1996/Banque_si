package org.dev.metier;

import java.util.List;

import org.dev.dao.EmployeRepository;
import org.dev.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeMetierImp implements EmployeMetier {

	@Autowired
	private EmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
