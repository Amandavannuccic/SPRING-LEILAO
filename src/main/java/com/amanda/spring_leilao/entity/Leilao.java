package com.amanda.spring_leilao.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEILAO")
@Entity
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_INICIAL")
    private LocalDateTime dataInicial;

    @Column(name = "DATA_FINAL")
    private LocalDateTime dataFinal;

    @Column(name = "LOCAL")
    private String local;

    @OneToMany(mappedBy = "leilao", fetch = FetchType.EAGER)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "leilao", fetch = FetchType.EAGER)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "leilao", fetch = FetchType.EAGER)
    private List<InstituicaoFinanceira> instituicoesFinanceiras;

    @Column(name= "STATUS")
    private String status;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "HORARIO_INICIO")
    private LocalTime horarioInicio;

    @Column(name = "HORARIO_FIM")
    private LocalTime horarioFim;
}