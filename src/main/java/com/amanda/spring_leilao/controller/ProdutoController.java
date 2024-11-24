package com.amanda.spring_leilao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.spring_leilao.dto.ProdutoDTO;
import com.amanda.spring_leilao.entity.Produto;
import com.amanda.spring_leilao.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> getAllProdutos() {
        return produtoService.getAllProdutos().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @PostMapping
    public ProdutoDTO createProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = convertToEntity(produtoDTO);
        return convertToDTO(produtoService.createProduto(produto));
    }

    @PutMapping("/{id}")
    public ProdutoDTO updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = convertToEntity(produtoDTO);
        return convertToDTO(produtoService.updateProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }

    private ProdutoDTO convertToDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPrecoInicial(produto.getPrecoInicial());
        return produtoDTO;
    }

    private Produto convertToEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setPrecoInicial(produtoDTO.getPrecoInicial());
        return produto;
    }
}