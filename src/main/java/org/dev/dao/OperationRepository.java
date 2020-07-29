package org.dev.dao;

import org.dev.entities.Compte;
import org.dev.entities.Operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long >{
//	@Query("select o from Operation where o.Compte.codeCompte=:x")
//	public Page<Operation> getOperation(@Param("x") String codeCompte,Pageable pageable);

	//deuxieme methode
 public Page<Operation> findByCompte(Compte cp,Pageable pageable);
}
