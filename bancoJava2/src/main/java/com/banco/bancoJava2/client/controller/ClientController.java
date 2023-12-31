package com.banco.bancoJava2.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancoJava2.dto.ClientDTO;
import com.banco.bancoJava2.entity.Client;
import com.banco.bancoJava2.exception.ClientNotFoundException;
import com.banco.bancoJava2.exception.CpfAlreadyRegistered;
import com.banco.bancoJava2.service.ClientService;
import com.banco.bancoJava2.service.SuccessMessage;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/bancoricardo/clientes")
public class ClientController {
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDTO registerClient(@Valid @RequestBody ClientDTO clientDTO) throws CpfAlreadyRegistered {
		Client client = ClientDTO.returnClient(clientDTO);
		Client clientSaved = this.clientService.registerClient(client);
		ClientDTO clientDTOsaved = ClientDTO.returnClientDTO(clientSaved);
		return clientDTOsaved;
	}
	
	@GetMapping
	public List<ClientDTO> returnAllClients() {
		List<Client> clients =  this.clientService.returnAllClients();
		return ClientDTO.listClientsDTO(clients);
	}
	
	@GetMapping("{cpf}")
	public ClientDTO getClient(@PathVariable String cpf) throws ClientNotFoundException {
		Client client = this.clientService.getClient(cpf);
		ClientDTO clientDTO = ClientDTO.returnClientDTO(client);
		return clientDTO;
	}
	
	@PutMapping("/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public ClientDTO updateClient(@PathVariable String cpf, @Valid @RequestBody ClientDTO clientDTO) throws ClientNotFoundException {
		Client client = ClientDTO.returnClient(clientDTO);
		Client clientSaved =  this.clientService.updateClient(cpf, client);
		ClientDTO clientDTOsaved = ClientDTO.returnClientDTO(clientSaved);
		return clientDTOsaved;
	}
	
	@DeleteMapping("/{cpf}")
	public SuccessMessage deleteClient(@PathVariable String cpf) throws ClientNotFoundException {
		return this.clientService.deleteClient(cpf);
	}
	
	///necessario estudar aqui a questao da propagacao do efeito delete e update (com o objeto endereco)
}
