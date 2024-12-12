package com.amanda.spring_leilao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("DispositivoInformatica")
public class DispositivoInformatica extends Produto {
    private String especificacoes;

    @Override
    public String getEspecificacoes() {
        return especificacoes;
    }

    @Override
    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public Object getTipoDispoitivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipoDispoitivo'");
    }

    public void setTipoDispoitivo(Object tipoDispoitivo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTipoDispoitivo'");
    }
}
