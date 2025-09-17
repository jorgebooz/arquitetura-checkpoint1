package com.fiap.lojaonline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {
    private String nome;
    private String preco;
    private String categoria;
    private String descricao;
    private Boolean ativo;
}
