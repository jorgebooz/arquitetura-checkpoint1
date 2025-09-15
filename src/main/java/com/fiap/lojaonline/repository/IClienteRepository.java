package com.fiap.lojaonline.repository;
import com.fiap.lojaonline.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> { }
