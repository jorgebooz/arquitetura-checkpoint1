package com.fiap.lojaonline.repository;
import com.fiap.lojaonline.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> { }
