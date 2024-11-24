package com.amanda.spring_leilao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUTO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO_INICIAL")
    private double precoInicial;

    @Column(name = "DTYPE", insertable = false, updatable = false)
    private String dtype;

    @Column(name = "TIPO")
    @JsonIgnore
    private String tipo;

    @ManyToOne
    private Leilao leilao;

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}