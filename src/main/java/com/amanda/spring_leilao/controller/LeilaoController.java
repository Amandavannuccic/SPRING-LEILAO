package com.amanda.spring_leilao.controller;

import com.amanda.spring_leilao.dto.LeilaoDTO;
import com.amanda.spring_leilao.entity.Leilao;
import com.amanda.spring_leilao.service.LeilaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leiloes")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @GetMapping
    public List<LeilaoDTO> getAllLeiloes() {
        return leilaoService.getAllLeiloes().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LeilaoDTO getLeilaoById(@PathVariable Long id) {
        return leilaoService.getLeilaoById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @GetMapping("/date")
    public List<Leilao> listarLeiloes() {
        return leilaoService.listarLeiloesOrdenadosPorData();
    }

    @GetMapping("/exportar/{id}")
    public String exportarLeilao(@PathVariable Long id) {
        try {
            leilaoService.exportarLeilaoParaArquivo(id);
            return "Leilão exportado com sucesso!";
        } catch (IOException e) {
            return "Erro ao exportar leilão: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @PostMapping
    public LeilaoDTO createLeilao(@RequestBody LeilaoDTO leilaoDTO) {
        Leilao leilao = convertToEntity(leilaoDTO);
        return convertToDTO(leilaoService.createLeilao(leilao));
    }

    @PutMapping("/{id}")
    public LeilaoDTO updateLeilao(@PathVariable Long id, @RequestBody LeilaoDTO leilaoDTO) {
        Leilao leilao = convertToEntity(leilaoDTO);
        return convertToDTO(leilaoService.updateLeilao(id, leilao));
    }

    @DeleteMapping("/{id}")
    public void deleteLeilao(@PathVariable Long id) {
        leilaoService.deleteLeilao(id);
    }

    private LeilaoDTO convertToDTO(Leilao leilao) {
        LeilaoDTO dto = new LeilaoDTO();
        dto.setId(leilao.getId());
        dto.setDescricao(leilao.getDescricao());
        dto.setLocal(leilao.getLocal());
        dto.setStatus(leilao.getStatus());
      
        return dto;
    }

    private Leilao convertToEntity(LeilaoDTO leilaoDTO) {
        Leilao leilao = new Leilao();
        leilao.setId(leilaoDTO.getId());
        leilao.setDescricao(leilaoDTO.getDescricao());
        leilao.setLocal(leilaoDTO.getLocal());
        leilao.setStatus(leilaoDTO.getStatus());
       
        return leilao;
    }
}