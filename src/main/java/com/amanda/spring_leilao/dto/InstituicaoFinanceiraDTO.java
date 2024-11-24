package com.amanda.spring_leilao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstituicaoFinanceiraDTO {

    private Long id;
    private String cnpj;
    private String nome;
    private Long leilaoId; // Adicione esta linha para referenciar o leilao
}