package com.fiap.lojaonline.controller;

import com.fiap.lojaonline.dto.ClienteRequestDTO;
import com.fiap.lojaonline.dto.ClienteResponseDTO;
import com.fiap.lojaonline.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@RequestBody ClienteRequestDTO dto){
        ClienteResponseDTO cliente = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @RequestBody ClienteRequestDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
