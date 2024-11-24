package com.amanda.spring_leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amanda.spring_leilao.dto.InstituicaoFinanceiraDTO;
import com.amanda.spring_leilao.entity.InstituicaoFinanceira;
import com.amanda.spring_leilao.service.InstituicaoFinanceiraService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/instituicoesFinanceiras")
public class InstituicaoFinanceiraController {

    @Autowired
    private InstituicaoFinanceiraService instituicaoFinanceiraService;

    @GetMapping
    public List<InstituicaoFinanceiraDTO> getAllInstituicoesFinanceiras() {
        return instituicaoFinanceiraService.getAllInstituicoesFinanceiras().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public InstituicaoFinanceiraDTO getInstituicaoFinanceiraById(@PathVariable Long id) {
        return instituicaoFinanceiraService.getInstituicaoFinanceiraById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @PostMapping
    public InstituicaoFinanceiraDTO createInstituicaoFinanceira(@RequestBody InstituicaoFinanceiraDTO instituicaoFinanceiraDTO) {
        InstituicaoFinanceira instituicaoFinanceira = convertToEntity(instituicaoFinanceiraDTO);
        return convertToDTO(instituicaoFinanceiraService.createInstituicaoFinanceira(instituicaoFinanceira));
    }

    @PutMapping("/{id}")
    public InstituicaoFinanceiraDTO updateInstituicaoFinanceira(@PathVariable Long id, @RequestBody InstituicaoFinanceiraDTO instituicaoFinanceiraDTO) {
        InstituicaoFinanceira instituicaoFinanceira = convertToEntity(instituicaoFinanceiraDTO);
        return convertToDTO(instituicaoFinanceiraService.updateInstituicaoFinanceira(id, instituicaoFinanceira));
    }

    @DeleteMapping("/{id}")
    public void deleteInstituicaoFinanceira(@PathVariable Long id) {
        instituicaoFinanceiraService.deleteInstituicaoFinanceira(id);
    }

    private InstituicaoFinanceiraDTO convertToDTO(InstituicaoFinanceira instituicaoFinanceira) {
        InstituicaoFinanceiraDTO dto = new InstituicaoFinanceiraDTO();
        dto.setId(instituicaoFinanceira.getId());
        dto.setCnpj(instituicaoFinanceira.getCnpj());
        dto.setNome(instituicaoFinanceira.getNome());
        return dto;
    }

    private InstituicaoFinanceira convertToEntity(InstituicaoFinanceiraDTO instituicaoFinanceiraDTO) {
        InstituicaoFinanceira instituicaoFinanceira = new InstituicaoFinanceira();
        instituicaoFinanceira.setId(instituicaoFinanceiraDTO.getId());
        instituicaoFinanceira.setCnpj(instituicaoFinanceiraDTO.getCnpj());
        instituicaoFinanceira.setNome(instituicaoFinanceiraDTO.getNome());
        return instituicaoFinanceira;
    }
}