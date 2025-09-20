package com.fiap.lojaonline.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {

    @Schema(description = "Nome do produto", example = "Notebook Gamer")
    private String nome;

    @Schema(description = "Preço do produto (maior que zero)", example = "4500.50")
    private String preco;

    @Schema(description = "Categoria do produto", example = "Eletrônicos")
    private String categoria;

    @Schema(description = "Descrição detalhada do produto", example = "Notebook Gamer com 16GB RAM, SSD 512GB")
    private String descricao;

    @Schema(description = "Indica se o produto está ativo", example = "true")
    private Boolean ativo;
}
