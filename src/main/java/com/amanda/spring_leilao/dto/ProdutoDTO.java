package com.amanda.spring_leilao.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double precoInicial;
    private Long leilaoId;
    private String tipo; // Campo para identificar o tipo de produto

    private String especificacoes;
    private String resolucao; 
    private String capacidadeCarga; 
    private String modelo; 
    private String marca; 
    private String cilindrada;

    // Remova os métodos não implementados e adicione os métodos corretos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}