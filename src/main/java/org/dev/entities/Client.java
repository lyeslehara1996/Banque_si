package org.dev.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sun.istack.NotNull;
@Entity
@Table(name = "Client")

public class Client implements Serializable {
	@Id
	 @Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @NotNull
	private long codeClient;
	private String nomClient;
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomClient, Collection<Compte> comptes) {
		super();
		this.nomClient = nomClient;
		this.comptes = comptes;
	}
	public long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
