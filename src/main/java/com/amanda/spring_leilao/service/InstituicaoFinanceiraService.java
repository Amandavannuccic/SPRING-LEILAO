package com.amanda.spring_leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.spring_leilao.entity.InstituicaoFinanceira;
import com.amanda.spring_leilao.repository.InstituicaoFinanceiraRepository;

@Service
public class InstituicaoFinanceiraService {
    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    public List<InstituicaoFinanceira> getAllInstituicoesFinanceiras() {
        return instituicaoFinanceiraRepository.findAll();
    }

    public Optional<InstituicaoFinanceira> getInstituicaoFinanceiraById(Long id) {
        return instituicaoFinanceiraRepository.findById(id);
    }

    public InstituicaoFinanceira createInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) {
        return instituicaoFinanceiraRepository.save(instituicaoFinanceira);
    }

    public InstituicaoFinanceira updateInstituicaoFinanceira(Long id, InstituicaoFinanceira instituicaoFinanceiraDetails) {
        Optional<InstituicaoFinanceira> instituicaoFinanceiraOpt = instituicaoFinanceiraRepository.findById(id);
        if (instituicaoFinanceiraOpt.isPresent()) {
            InstituicaoFinanceira instituicaoFinanceira = instituicaoFinanceiraOpt.get();
            instituicaoFinanceira.setNome(instituicaoFinanceiraDetails.getNome());
            instituicaoFinanceira.setCnpj(instituicaoFinanceiraDetails.getCnpj());
            return instituicaoFinanceiraRepository.save(instituicaoFinanceira);
        }
        return null;
    }

    public void deleteInstituicaoFinanceira(Long id) {
        instituicaoFinanceiraRepository.deleteById(id);
    }
}