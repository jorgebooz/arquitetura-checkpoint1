package com.fiap.lojaonline.dto;

import com.fiap.lojaonline.model.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {

    @Schema(description = "Identificador único do cliente", example = "1")
    private Long id;

    @Schema(description = "Nome completo do cliente", example = "Maria Silva")
    private String nome;

    @Schema(description = "Email do cliente", example = "maria.silva@email.com")
    private String email;

    @Schema(description = "Documento do cliente", example = "123.456.789-00")
    private String documento;

    public ClienteResponseDTO(Cliente entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.documento = entity.getDocumento();
    }
}
