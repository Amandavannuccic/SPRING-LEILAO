package com.amanda.spring_leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amanda.spring_leilao.entity.DispositivoInformatica;

@Repository
public interface DispositivoInformaticaRepository extends JpaRepository<DispositivoInformatica, Long> {
}