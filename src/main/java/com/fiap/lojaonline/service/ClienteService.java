package com.fiap.lojaonline.service;

import com.fiap.lojaonline.dto.ClienteRequestDTO;
import com.fiap.lojaonline.dto.ClienteResponseDTO;
import com.fiap.lojaonline.exception.ConflitoNegocioException;
import com.fiap.lojaonline.exception.RecursoNaoEncontradoException;
import com.fiap.lojaonline.model.Cliente;
import com.fiap.lojaonline.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // CREATE
    public ClienteResponseDTO save(ClienteRequestDTO dto){
        // valida se já existe email
        if(repository.existsByEmailCliente(dto.getEmail())){
            throw new ConflitoNegocioException("Email já cadastrado");
        }

        var cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);

        Cliente saved = repository.save(cliente);
        return new ClienteResponseDTO(saved);
    }

    // READ ALL
    public List<ClienteResponseDTO> getAll() {
        List<Cliente> listClientes = repository.findAll();
        return listClientes.stream().map(ClienteResponseDTO::new).toList();
    }

    // READ BY ID
    public ClienteResponseDTO getById(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        return new ClienteResponseDTO(cliente);
    }

    // UPDATE
    public ClienteResponseDTO update(Long id, ClienteRequestDTO dto){
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        BeanUtils.copyProperties(dto, cliente);
        Cliente updated = repository.save(cliente);
        return new ClienteResponseDTO(updated);
    }

    // DELETE
    public void delete(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        repository.delete(cliente);
    }
}