package com.amanda.spring_leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.spring_leilao.entity.DispositivoInformatica;
import com.amanda.spring_leilao.repository.DispositivoInformaticaRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DispositivoInformaticaService {
    @Autowired
    private DispositivoInformaticaRepository dispositivoInformaticaRepository;

    public List<DispositivoInformatica> getAllDispositivos() {
        return dispositivoInformaticaRepository.findAll();
    }

    public Optional<DispositivoInformatica> getDispositivoById(Long id) {
        return dispositivoInformaticaRepository.findById(id);
    }

    public DispositivoInformatica createDispositivo(DispositivoInformatica dispositivo) {
        return dispositivoInformaticaRepository.save(dispositivo);
    }

    public DispositivoInformatica updateDispositivo(Long id, DispositivoInformatica dispositivoDetails) {
        Optional<DispositivoInformatica> dispositivoOpt = dispositivoInformaticaRepository.findById(id);
        if (dispositivoOpt.isPresent()) {
            DispositivoInformatica dispositivo = dispositivoOpt.get();
            dispositivo.setTipoDispoitivo(dispositivoDetails.getTipoDispoitivo());
            // Atualize outros campos conforme necessário
            return dispositivoInformaticaRepository.save(dispositivo);
        }
        return null;
    }

    public void deleteDispositivo(Long id) {
        dispositivoInformaticaRepository.deleteById(id);
    }
}