package com.banco.bancoJava2.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client {
	
	@Id
	private String cpf;
	private String nome;
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Address endereco;
	
	private BigDecimal rendimentoMensal;
	
	public Client() {}
		
	public Client(String nome, String cpf, String telefone, Address endereco, BigDecimal rendimentoMensal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rendimentoMensal = rendimentoMensal;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Address getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Address endereco) {
		this.endereco = endereco;
	}
	
	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}
	
	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	
}
