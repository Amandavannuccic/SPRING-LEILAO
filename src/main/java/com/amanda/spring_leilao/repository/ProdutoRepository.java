package com.amanda.spring_leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanda.spring_leilao.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
