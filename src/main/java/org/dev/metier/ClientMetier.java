package org.dev.metier;

import java.util.List;

import org.dev.entities.Client;

public interface ClientMetier {

	public Client  saveClient(Client c); 
	public List<Client> listClients();
}
