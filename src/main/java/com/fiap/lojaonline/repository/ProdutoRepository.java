package com.fiap.lojaonline.repository;
import com.fiap.lojaonline.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
