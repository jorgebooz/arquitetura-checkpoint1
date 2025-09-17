package com.fiap.lojaonline.dto;

import com.fiap.lojaonline.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO{
    private Long id;
    private String nome;
    private String preco;
    private String categoria;
    private String descricao;
    private Boolean ativo;

    public ProdutoDTO(){}

    public ProdutoDTO(Produto entity){
        this.id = getId();
        this.nome = getNome();
        this.preco = getPreco();
        this.categoria = getCategoria();
        this.descricao = getDescricao();
        this.ativo = getAtivo();
    }

}
