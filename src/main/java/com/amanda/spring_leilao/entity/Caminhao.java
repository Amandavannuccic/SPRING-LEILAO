package com.amanda.spring_leilao.entity;

import jakarta.persistence.*;
import lombok.*;

@DiscriminatorValue("Caminhao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Caminhao extends Produto {
    private String especificacoes;

    @Override
    public String getEspecificacoes() {
        return especificacoes;
    }

    @Override
    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }
}
