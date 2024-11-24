package com.amanda.spring_leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanda.spring_leilao.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
