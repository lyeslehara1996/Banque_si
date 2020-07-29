package org.dev.metier;

import java.util.List;

import org.dev.dao.ClientRepository;
import org.dev.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientMetierImp implements ClientMetier {
	
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public Client saveClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
