package com.fiap.lojaonline.dto;

import com.fiap.lojaonline.model.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String documento;

    public ClienteDTO(){}

    public ClienteDTO(Cliente entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.documento = entity.getDocumento();
    }
}
