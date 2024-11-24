package com.amanda.spring_leilao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Veiculo extends Produto {

    @Column(name = "TIPO_VEICULO")
    private String tipoVeiculo; // carro, moto, caminhão, etc.

}