package org.dev.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@Table(name = "Employe")
public class Employe  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codeEmploye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn(name = "code_emp_sup")
	private Employe employeSup;
	@ManyToMany
	@JoinTable(name = "EMP_GR")  
	private Collection<Groupe> groupes;
	@OneToMany(mappedBy = "employe",fetch = FetchType.LAZY)
	private Collection<Compte> compte;
	public long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	@JsonIgnore
	public Employe getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupe() {
		return groupes;
	}
	@JsonSetter
	public void setGroupe(Collection<Groupe> groupe) {
		this.groupes = groupe;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	
	
	
}
