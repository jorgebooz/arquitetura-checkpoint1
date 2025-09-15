package com.fiap.lojaonline.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name =  "produtos")
@Getter
@Setter
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Positive(message = "Preço deve ser maior que zero")
    @Column(nullable = false)
    private BigDecimal preco;

    @Column
    @Size(max=255)
    private String categoria;

    @Column
    @Size(max=255)
    private String descricao;

    @Column
    private boolean ativo = true;
}
