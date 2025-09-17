package com.fiap.lojaonline.dto;

import com.fiap.lojaonline.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponseDTO{
    private Long id;
    private String nome;
    private String preco;
    private String categoria;
    private String descricao;
    private Boolean ativo;

    public ProdutoResponseDTO(Produto entity){
        this.id = getId();
        this.nome = getNome();
        this.preco = getPreco();
        this.categoria = getCategoria();
        this.descricao = getDescricao();
        this.ativo = getAtivo();
    }

}
