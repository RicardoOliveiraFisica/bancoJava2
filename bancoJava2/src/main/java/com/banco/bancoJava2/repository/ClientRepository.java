package com.banco.bancoJava2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancoJava2.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByCpf(String cpf);
	
	boolean existsByCpf(String cpf);
}
