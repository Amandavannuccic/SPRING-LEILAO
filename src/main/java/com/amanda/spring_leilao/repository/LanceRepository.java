package com.amanda.spring_leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanda.spring_leilao.entity.Lance;

public interface LanceRepository extends JpaRepository<Lance, Long> {}