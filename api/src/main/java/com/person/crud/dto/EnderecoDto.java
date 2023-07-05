package com.person.crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@NotBlank
public class EnderecoDto {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
