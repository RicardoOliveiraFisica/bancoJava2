package com.banco.bancoJava2.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancoJava2.dto.ClientDTO;
import com.banco.bancoJava2.entity.Client;
import com.banco.bancoJava2.service.ClientService;

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
	public ClientDTO registerClient(@Valid @RequestBody ClientDTO clientDTO) {
		Client client = ClientDTO.returnClient(clientDTO);
		Client clientSaved = this.clientService.registerClient(client);
		ClientDTO clientDTOsaved = ClientDTO.returnClientDTO(clientSaved);
		return clientDTOsaved;
	}
	
	@GetMapping
	public List<Client> returnAllClients() {
		return this.clientService.returnAllClients();
	}
	
	@GetMapping("{cpf}")
	public ClientDTO getClient(@PathVariable String cpf) {
		Client client = this.clientService.getClient(cpf);
		ClientDTO clientDTO = ClientDTO.returnClientDTO(client);
		return clientDTO;
	}
}
