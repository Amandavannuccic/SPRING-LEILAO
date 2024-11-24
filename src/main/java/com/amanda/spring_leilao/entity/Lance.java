package com.amanda.spring_leilao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name  = "LANCE")
@Entity
public class Lance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "ID")
    private Long id;
   
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
   
    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    private Produto produto;
   
    @Column(name= "VALOR")
    private double valor;

}