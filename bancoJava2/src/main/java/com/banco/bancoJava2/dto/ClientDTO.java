package com.banco.bancoJava2.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.banco.bancoJava2.entity.Address;
import com.banco.bancoJava2.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  
@AllArgsConstructor 
@Getter
@Setter
public class ClientDTO {
	private String cpf;
	private String nome;
	private String telefone;
	private String rua;
	private Integer numero;
	private String cep;
	private BigDecimal rendimentoMensal;
		
	public ClientDTO(Client client) {
		super();
		this.nome = client.getNome();
		this.cpf = client.getCpf();
		this.telefone = client.getTelefone();
		this.rua = client.getEndereco().getRua();
		this.numero = client.getEndereco().getNumero();
		this.cep = client.getEndereco().getCep();
		this.rendimentoMensal = client.getRendimentoMensal();		
	}
	
	public static Client returnClient(ClientDTO clientDTO) {
		Address address = new Address(clientDTO.rua, clientDTO.numero, clientDTO.cep);
		Client client = new Client(clientDTO.nome, clientDTO.cpf, clientDTO.telefone, address, clientDTO.rendimentoMensal);
		return client;
	}
	
	public static ClientDTO returnClientDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO(client);
		return clientDTO;
	}
	
	public static List<ClientDTO> listClientsDTO(List<Client> clients) {
		List<ClientDTO> clientsDTO = new ArrayList<>();
		for (Client client : clients) {
			ClientDTO clientDTO = ClientDTO.returnClientDTO(client);
			clientsDTO.add(clientDTO);
		}
		return clientsDTO;
	}
	
}
