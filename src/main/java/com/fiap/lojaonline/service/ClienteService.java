package com.fiap.lojaonline.service;

import com.fiap.lojaonline.dto.ClienteRequestDTO;
import com.fiap.lojaonline.model.Cliente;
import com.fiap.lojaonline.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    //create
    @PostMapping
    public ResponseEntity save(@RequestBody ClienteRequestDTO dto){
        var cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    //read
    @GetMapping
    public ResponseEntity getAll() {
        List<Cliente> listClientes = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listClientes);
    }

    @GetMapping("{/id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id){
        Optional cliente = repository.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(cliente.get());
    }

    //update
    @PutMapping
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody ClienteRequestDTO dto){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        var clienteModel = cliente.get();
        BeanUtils.copyProperties(dto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(clienteModel));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        repository.delete(cliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado");
    }
}
