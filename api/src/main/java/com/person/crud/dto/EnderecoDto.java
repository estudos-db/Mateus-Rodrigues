package com.person.crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class EnderecoDto {

    @NotBlank(message = "Campo obrigatório")
    private String rua;
    @NotBlank(message = "Campo obrigatório")
    private String numero;
    @NotBlank(message = "Campo obrigatório")
    private String bairro;
    @NotBlank(message = "Campo obrigatório")
    private String cidade;
    @NotBlank(message = "Campo obrigatório")
    private String estado;
    @NotBlank(message = "Campo obrigatório")
    private String cep;
}
