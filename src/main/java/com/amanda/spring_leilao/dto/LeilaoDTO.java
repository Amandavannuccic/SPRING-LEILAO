package com.amanda.spring_leilao.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeilaoDTO {
    
    private Long id;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private String local;
    private List<ProdutoDTO> produtos; // Use ProdutoDTO
    private List<ClienteDTO> clientes; // Use ClienteDTO
    private List<InstituicaoFinanceiraDTO> instituicoesFinanceiras; // Use InstituicaoFinanceiraDTO
    private String status; // EM ABERTO, EM ANDAMENTO, FINALIZADO
    private String descricao;
}