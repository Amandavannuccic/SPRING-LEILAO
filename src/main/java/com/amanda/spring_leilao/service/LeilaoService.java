package com.amanda.spring_leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.spring_leilao.dto.LeilaoDTO;
import com.amanda.spring_leilao.dto.ProdutoDTO;
import com.amanda.spring_leilao.dto.ClienteDTO;
import com.amanda.spring_leilao.dto.InstituicaoFinanceiraDTO;
import com.amanda.spring_leilao.entity.*;
import com.amanda.spring_leilao.repository.LeilaoRepository;

import jakarta.transaction.Transactional;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.gson.Gson;

@Service
@Transactional
public class LeilaoService {
    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Leilao> getAllLeiloes() {
        return leilaoRepository.findAll();
    }

    public Optional<Leilao> getLeilaoById(Long id) {
        return leilaoRepository.findById(id);
    }

    public Leilao createLeilao(Leilao leilao) {
        return leilaoRepository.save(leilao);
    }

    public Leilao updateLeilao(Long id, Leilao leilaoDetails) {
        Optional<Leilao> leilaoOpt = leilaoRepository.findById(id);
        if (leilaoOpt.isPresent()) {
            Leilao leilao = leilaoOpt.get();
            leilao.setDataInicial(leilaoDetails.getDataInicial());
            leilao.setDataFinal(leilaoDetails.getDataFinal());
            leilao.setLocal(leilaoDetails.getLocal());
            leilao.setStatus(leilaoDetails.getStatus());
            leilao.setHorarioInicio(leilaoDetails.getHorarioInicio());
            leilao.setHorarioFim(leilaoDetails.getHorarioFim());
            return leilaoRepository.save(leilao);
        }
        return null;
    }

    public void deleteLeilao(Long id) {
        leilaoRepository.deleteById(id);
    }

     public LeilaoDTO convertToDTO(Leilao leilao) {
        LeilaoDTO dto = new LeilaoDTO();
        dto.setId(leilao.getId());
        dto.setDescricao(leilao.getDescricao());
        dto.setLocal(leilao.getLocal());
        dto.setStatus(leilao.getStatus());
        dto.setDataInicial(leilao.getDataInicial());
        dto.setDataFinal(leilao.getDataFinal());
        dto.setProdutos(leilao.getProdutos().stream().map(this::convertProdutoToDTO).collect(Collectors.toList()));
        dto.setClientes(leilao.getClientes().stream().map(this::convertClienteToDTO).collect(Collectors.toList()));
        dto.setInstituicoesFinanceiras(leilao.getInstituicoesFinanceiras().stream().map(this::convertInstituicaoFinanceiraToDTO).collect(Collectors.toList()));
        return dto;
    }

    private ProdutoDTO convertProdutoToDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPrecoInicial(produto.getPrecoInicial());
        dto.setLeilaoId(produto.getLeilao().getId());
    
        if (produto instanceof Notebook) {
            Notebook notebook = (Notebook) produto;
            dto.setEspecificacoes(notebook.getEspecificacoes());
        } else if (produto instanceof Monitor) {
            Monitor monitor = (Monitor) produto;
            dto.setResolucao(monitor.getEspecificacoes());
        } else if (produto instanceof Caminhao) {
            Caminhao caminhao = (Caminhao) produto;
            dto.setCapacidadeCarga(caminhao.getEspecificacoes());
        } else if (produto instanceof Carro) {
            Carro carro = (Carro) produto;
            dto.setModelo(carro.getEspecificacoes());
            dto.setMarca(carro.getEspecificacoes());
        } else if (produto instanceof Moto) {
            Moto motocicleta = (Moto) produto;
            dto.setCilindrada(motocicleta.getEspecificacoes());
        }
    
        return dto;
    }

    private ClienteDTO convertClienteToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setLeilaoId(cliente.getLeilao().getId());
        return dto;
    }

    private InstituicaoFinanceiraDTO convertInstituicaoFinanceiraToDTO(InstituicaoFinanceira instituicaoFinanceira) {
        InstituicaoFinanceiraDTO dto = new InstituicaoFinanceiraDTO();
        dto.setId(instituicaoFinanceira.getId());
        dto.setCnpj(instituicaoFinanceira.getCnpj());
        dto.setNome(instituicaoFinanceira.getNome());
        dto.setLeilaoId(instituicaoFinanceira.getLeilao().getId());
        return dto;
    }

    public List<Leilao> listarLeiloesOrdenadosPorData() {
        return leilaoRepository.findAllByOrderByDataInicialAsc();
    }

    public Optional<Leilao> obterDetalhesLeilao(Long id) {
        return leilaoRepository.findById(id);
    }

    public void exportarLeilaoParaArquivo(Long id) throws IOException {
        Optional<Leilao> leilaoOpt = obterDetalhesLeilao(id);
        if (leilaoOpt.isPresent()) {
            Leilao leilao = leilaoOpt.get();
            Gson gson = new Gson();
            String json = gson.toJson(leilao);
            try (FileWriter writer = new FileWriter("leilao_" + id + ".det")) {
                writer.write(json);
            }
        } else {
            throw new IllegalArgumentException("Leilão não encontrado");
        }
    }


}