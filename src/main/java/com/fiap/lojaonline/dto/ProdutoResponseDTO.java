package com.fiap.lojaonline.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fiap.lojaonline.model.Produto;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoResponseDTO {

    @Schema(description = "Identificador único do produto", example = "1")
    private Long id;

    @Schema(description = "Nome do produto", example = "Notebook Gamer")
    private String nome;

    @Schema(description = "Preço do produto", example = "4500.50")
    private BigDecimal preco;

    @Schema(description = "Categoria do produto", example = "Eletrônicos")
    private String categoria;

    @Schema(description = "Descrição detalhada do produto", example = "Notebook Gamer com 16GB RAM, SSD 512GB")
    private String descricao;

    @Schema(description = "Indica se o produto está ativo", example = "true")
    private Boolean ativo;

    // Construtor que copia propriedades da entidade
    public ProdutoResponseDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
        this.descricao = produto.getDescricao();
        this.ativo = produto.isAtivo();
    }
}
