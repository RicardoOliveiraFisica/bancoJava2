package com.banco.bancoJava2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancoJava2.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
