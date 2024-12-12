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
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPrecoInicial(produto.getPrecoInicial());
        produtoDTO.setEspecificacoes(produto.getEspecificacoes());
        produtoDTO.setTipo(produto.getClass().getSimpleName());
        return produtoDTO;
    }

    private Produto convertToEntity(ProdutoDTO produtoDTO) {
    Produto produto;

    String tipo = produtoDTO.getTipo();
    if (tipo == null) {
        throw new IllegalArgumentException("Tipo de produto não pode ser nulo");
    }

    switch (tipo) {
        case "DispositivoInformatica":
            produto = new DispositivoInformatica();
            break;
        case "Veiculo":
            produto = new Veiculo();
            break;
        default:
            throw new IllegalArgumentException("Tipo de produto desconhecido: " + tipo);
    }

    produto.setId(produtoDTO.getId());
    produto.setNome(produtoDTO.getNome());
    produto.setPrecoInicial(produtoDTO.getPrecoInicial());
    produto.setEspecificacoes(produtoDTO.getEspecificacoes());
    return produto;
}
}