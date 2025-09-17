package com.fiap.lojaonline.dto;

import com.fiap.lojaonline.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {
    private String nome;
    private String email;
    private String documento;
}
