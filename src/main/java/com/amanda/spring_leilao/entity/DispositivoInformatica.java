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
public class DispositivoInformatica extends Produto {
    
    @Column(name = "TIPO_DISPOSITIVO")
    private String tipoDispoitivo;

}