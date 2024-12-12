package com.amanda.spring_leilao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("Veiculo")
public class Veiculo extends Produto {
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