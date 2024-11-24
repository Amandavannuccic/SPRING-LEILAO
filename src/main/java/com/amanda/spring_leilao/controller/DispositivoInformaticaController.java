package com.amanda.spring_leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amanda.spring_leilao.entity.DispositivoInformatica;
import com.amanda.spring_leilao.service.DispositivoInformaticaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dispositivos-informatica")
public class DispositivoInformaticaController {
    @Autowired
    private DispositivoInformaticaService dispositivoInformaticaService;

    @GetMapping
    public List<DispositivoInformatica> getAllDispositivos() {
        return dispositivoInformaticaService.getAllDispositivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispositivoInformatica> getDispositivoById(@PathVariable Long id) {
        Optional<DispositivoInformatica> dispositivo = dispositivoInformaticaService.getDispositivoById(id);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DispositivoInformatica createDispositivo(@RequestBody DispositivoInformatica dispositivo) {
        return dispositivoInformaticaService.createDispositivo(dispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoInformatica> updateDispositivo(@PathVariable Long id, @RequestBody DispositivoInformatica dispositivoDetails) {
        DispositivoInformatica updatedDispositivo = dispositivoInformaticaService.updateDispositivo(id, dispositivoDetails);
        return updatedDispositivo != null ? ResponseEntity.ok(updatedDispositivo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoInformaticaService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }
}