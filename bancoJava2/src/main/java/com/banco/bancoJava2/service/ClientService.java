package com.banco.bancoJava2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancoJava2.entity.Client;
import com.banco.bancoJava2.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client registerClient(Client client) {
		return this.clientRepository.save(client);
	}
	
	public List<Client> returnAllClients() {
		List<Client> clients = this.clientRepository.findAll();		
		return clients;
	}
}
