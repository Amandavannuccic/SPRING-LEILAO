package com.amanda.spring_leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.spring_leilao.entity.Produto;
import com.amanda.spring_leilao.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produtoDetails) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setNome(produtoDetails.getNome());
            produto.setPrecoInicial(produtoDetails.getPrecoInicial());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}