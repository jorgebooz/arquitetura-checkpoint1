package com.fiap.lojaonline.repository;

import com.fiap.lojaonline.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByDocumento(String documento);
    boolean existsByEmail(String email);
}
