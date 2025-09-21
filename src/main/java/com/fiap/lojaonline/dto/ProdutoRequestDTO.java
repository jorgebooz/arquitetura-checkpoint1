package com.fiap.lojaonline.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "Preço do produto (maior que zero)", example = "4500.50")
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double preco; // Mudei para Double (era String)

    @Schema(description = "Categoria do produto", example = "Eletrônicos")
    @NotBlank(message = "Categoria é obrigatória")
    private String categoria;

    @Schema(description = "Descrição detalhada do produto", example = "Notebook Gamer com 16GB RAM, SSD 512GB")
    private String descricao;

    @Schema(description = "Indica se o produto está ativo", example = "true")
    @NotNull(message = "Status ativo é obrigatório")
    private Boolean ativo;
}