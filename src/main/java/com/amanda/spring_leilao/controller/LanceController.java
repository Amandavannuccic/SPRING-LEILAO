package com.amanda.spring_leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amanda.spring_leilao.dto.ClienteDTO;
import com.amanda.spring_leilao.dto.DispositivoInformaticaDTO;
import com.amanda.spring_leilao.dto.LanceDTO;
import com.amanda.spring_leilao.dto.ProdutoDTO;
import com.amanda.spring_leilao.dto.VeiculoDTO;
import com.amanda.spring_leilao.entity.Cliente;
import com.amanda.spring_leilao.entity.DispositivoInformatica;
import com.amanda.spring_leilao.entity.Lance;
import com.amanda.spring_leilao.entity.Produto;
import com.amanda.spring_leilao.entity.Veiculo;
import com.amanda.spring_leilao.service.LanceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lances")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @GetMapping
    public List<LanceDTO> getAllLances() {
        return lanceService.getAllLances().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LanceDTO getLanceById(@PathVariable Long id) {
        return lanceService.getLanceById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @PostMapping
    public LanceDTO createLance(@RequestBody LanceDTO lanceDTO) {
        Lance lance = convertToEntity(lanceDTO);
        return convertToDTO(lanceService.createLance(lance));
    }

    @PutMapping("/{id}")
    public LanceDTO updateLance(@PathVariable Long id, @RequestBody LanceDTO lanceDTO) {
        Lance lance = convertToEntity(lanceDTO);
        return convertToDTO(lanceService.updateLance(id, lance));
    }

    @DeleteMapping("/{id}")
    public void deleteLance(@PathVariable Long id) {
        lanceService.deleteLance(id);
    }

    private LanceDTO convertToDTO(Lance lance) {
        LanceDTO dto = new LanceDTO();
        dto.setId(lance.getId());
        dto.setCliente(convertToDTO(lance.getCliente()));
        dto.setProduto(convertToDTO(lance.getProduto()));
        dto.setValor(lance.getValor());
        return dto;
    }

    private Lance convertToEntity(LanceDTO lanceDTO) {
        Lance lance = new Lance();
        lance.setId(lanceDTO.getId());
        lance.setCliente(convertToEntity(lanceDTO.getCliente()));
                lance.setProduto(convertToEntity(lanceDTO.getProduto()));
                                lance.setValor(lanceDTO.getValor());
                                return lance;
                            }
                        
                            private Produto convertToEntity(Produto produto) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'convertToEntity'");
                    }
                
                            private Cliente convertToEntity(Cliente cliente) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'convertToEntity'");
            }
        
            private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        return dto;
    }

    private Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        return cliente;
    }

    private ProdutoDTO convertToDTO(Produto produto) {
        if (produto instanceof DispositivoInformatica) {
            DispositivoInformatica dispositivo = (DispositivoInformatica) produto;
            DispositivoInformaticaDTO dto = new DispositivoInformaticaDTO();
            dto.setId(dispositivo.getId());
            dto.setNome(dispositivo.getNome());
            dto.setPrecoInicial(dispositivo.getPrecoInicial());
            dto.setTipo(dispositivo.getTipo());
            return dto;
        } else if (produto instanceof Veiculo) {
            Veiculo veiculo = (Veiculo) produto;
            VeiculoDTO dto = new VeiculoDTO();
            dto.setId(veiculo.getId());
            dto.setNome(veiculo.getNome());
            dto.setPrecoInicial(veiculo.getPrecoInicial());
            dto.setTipo(veiculo.getTipo());
            return dto;
        }
        return null;
    }

    private Produto convertToEntity(ProdutoDTO produtoDTO) {
        if (produtoDTO instanceof DispositivoInformaticaDTO) {
            DispositivoInformaticaDTO dto = (DispositivoInformaticaDTO) produtoDTO;
            DispositivoInformatica dispositivo = new DispositivoInformatica();
            dispositivo.setId(dto.getId());
            dispositivo.setNome(dto.getNome());
            dispositivo.setPrecoInicial(dto.getPrecoInicial());
            dispositivo.setTipo(dto.getTipo());
            return dispositivo;
        } else if (produtoDTO instanceof VeiculoDTO) {
            VeiculoDTO dto = (VeiculoDTO) produtoDTO;
            Veiculo veiculo = new Veiculo();
            veiculo.setId(dto.getId());
            veiculo.setNome(dto.getNome());
            veiculo.setPrecoInicial(dto.getPrecoInicial());
            veiculo.setTipo(dto.getTipo());
            return veiculo;
        }
        return null;
    }
}