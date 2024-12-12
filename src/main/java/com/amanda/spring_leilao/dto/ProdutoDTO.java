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
    private Double precoInicial;
    private Long leilaoId;
    private String tipo; // Campo para identificar o tipo de produto

    private String especificacoes;
    private String resolucao; 
    private String capacidadeCarga; 
    private String modelo; 
    private String marca; 
    private String cilindrada;

    public void setTipo(String simpleName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTipo'");
    }
    public int getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    } 

    
}