package com.fiap.lojaonline.service;

import com.fiap.lojaonline.dto.ProdutoRequestDTO;
import com.fiap.lojaonline.dto.ProdutoResponseDTO;
import com.fiap.lojaonline.exception.ConflitoNegocioException;
import com.fiap.lojaonline.exception.RecursoNaoEncontradoException;
import com.fiap.lojaonline.model.Produto;
import com.fiap.lojaonline.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // CREATE
    public ProdutoResponseDTO save(ProdutoRequestDTO dto) {
        // Exemplo de regra de negócio: nome do produto deve ser único
        if (repository.existsByNome(dto.getNome())) {
            throw new ConflitoNegocioException("Produto com este nome já cadastrado");
        }

        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);

        Produto saved = repository.save(produto);
        return new ProdutoResponseDTO(saved);
    }

    // READ ALL
    public List<ProdutoResponseDTO> getAll() {
        List<Produto> listProdutos = repository.findAll();
        return listProdutos.stream().map(ProdutoResponseDTO::new).toList();
    }

    // READ BY ID
    public ProdutoResponseDTO getById(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));
        return new ProdutoResponseDTO(produto);
    }

    // UPDATE
    public ProdutoResponseDTO update(Long id, ProdutoRequestDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        BeanUtils.copyProperties(dto, produto);
        Produto updated = repository.save(produto);

        return new ProdutoResponseDTO(updated);
    }

    // DELETE
    public void delete(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        repository.delete(produto);
    }
}
