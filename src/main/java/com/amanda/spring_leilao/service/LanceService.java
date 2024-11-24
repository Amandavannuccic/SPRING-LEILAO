package com.amanda.spring_leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.spring_leilao.entity.Lance;
import com.amanda.spring_leilao.repository.LanceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LanceService {
    @Autowired
    private LanceRepository lanceRepository;

    public List<Lance> getAllLances() {
        return lanceRepository.findAll();
    }

    public Optional<Lance> getLanceById(Long id) {
        return lanceRepository.findById(id);
    }

    public Lance createLance(Lance lance) {
        return lanceRepository.save(lance);
    }

    public Lance updateLance(Long id, Lance lanceDetails) {
        Optional<Lance> lanceOpt = lanceRepository.findById(id);
        if (lanceOpt.isPresent()) {
            Lance lance = lanceOpt.get();
            lance.setValor(lanceDetails.getValor());
            return lanceRepository.save(lance);
        }
        return null;
    }

    public void deleteLance(Long id) {
        lanceRepository.deleteById(id);
    }
}