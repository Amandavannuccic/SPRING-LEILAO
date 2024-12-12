package com.amanda.spring_leilao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoInformaticaDTO extends ProdutoDTO {

    private String tipoDispositivo;
}