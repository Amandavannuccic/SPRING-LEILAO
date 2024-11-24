package com.amanda.spring_leilao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private double precoInicial;
    private String dtype;
    private String tipo;
    private Long leilaoId; // Adicione esta linha para referenciar o leilao
}