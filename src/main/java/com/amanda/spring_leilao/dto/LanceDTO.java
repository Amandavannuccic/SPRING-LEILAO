package com.amanda.spring_leilao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanceDTO {

    private Long id;
    private ClienteDTO cliente;
    private ProdutoDTO produto;
    private double valor;

    public void setProduto(ProdutoDTO produtoDTO) {
        this.produto = produtoDTO;
    }

    public void setCliente(ClienteDTO clienteDTO) {
        this.cliente = clienteDTO;
    }
}