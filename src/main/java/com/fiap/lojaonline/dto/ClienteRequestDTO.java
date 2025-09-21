package com.fiap.lojaonline.dto;

import com.fiap.lojaonline.model.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    @Schema(description = "Nome completo do cliente", example = "Maria Silva")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "Email do cliente", example = "maria.silva@email.com")
    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Schema(description = "Documento único (CPF ou CNPJ)", example = "123.456.789-00")
    @NotBlank(message = "Documento é obrigatório")
    private String documento;
}