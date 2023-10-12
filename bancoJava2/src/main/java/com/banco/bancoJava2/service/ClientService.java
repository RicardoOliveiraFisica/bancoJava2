package com.banco.bancoJava2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancoJava2.entity.Client;
import com.banco.bancoJava2.exception.ClientNotFoundException;
import com.banco.bancoJava2.exception.CpfAlreadyRegistered;
import com.banco.bancoJava2.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client registerClient(Client client) throws CpfAlreadyRegistered {
		if (!this.clientRepository.existsByCpf(client.getCpf())) {
			return this.clientRepository.save(client);
		}
		throw new CpfAlreadyRegistered(client.getCpf());
	}
	
	public List<Client> returnAllClients() {
		List<Client> clients = this.clientRepository.findAll();		
		return clients;
	}
	
	public Client getClient(String cpf) throws ClientNotFoundException {
		Client client = this.clientRepository.findByCpf(cpf);
		if (!client.isEmpty()) {
			return client;
		}
		throw new ClientNotFoundException(cpf);
	}
	
	public Client updateClient(String cpf, Client client) throws ClientNotFoundException {
		client.setCpf(cpf); //garantir que o cpf seja o mesmo
		if (this.clientRepository.existsByCpf(cpf)) {
			return this.clientRepository.save(client);
		}
		throw new ClientNotFoundException(cpf);
	}
	
	@Transactional
	public SuccessMessage deleteClient(String cpf) throws ClientNotFoundException {
		if (this.clientRepository.existsByCpf(cpf)) {
			this.clientRepository.deleteByCpf(cpf);
			SuccessMessage successMessage = new SuccessMessage("Cadastro deletado com sucesso");
			return successMessage;
		}
		throw new ClientNotFoundException(cpf);
		
	}
}
