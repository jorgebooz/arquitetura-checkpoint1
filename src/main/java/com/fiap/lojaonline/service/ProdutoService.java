package com.fiap.lojaonline.service;

import com.fiap.lojaonline.dto.ProdutoRequestDTO;
import com.fiap.lojaonline.dto.ProdutoResponseDTO;
import com.fiap.lojaonline.model.Produto;
import com.fiap.lojaonline.repository.ProdutoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    //create
    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoRequestDTO dto){
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    //read
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getAll() {
        List<Produto> listProdutos = repository.findAll();
        List<ProdutoResponseDTO> response = listProdutos.stream()
                .map(ProdutoResponseDTO::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{/id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.ok(new ProdutoResponseDTO(produto.get()));
    }

    //update
    @PutMapping
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody ProdutoRequestDTO dto){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        var produtoModel = produto.get();
        BeanUtils.copyProperties(dto, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(produtoModel));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        repository.delete(produto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
    }
}

