package com.amanda.spring_leilao.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO extends ProdutoDTO {

    @Column(name = "ID")
    private String tipo;
    
}