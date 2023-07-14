package com.person.crud.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class EnderecoDto {

    @NotBlank(message = "Campo Rua obrigatório")
    private String rua;
    @NotBlank(message = "Campo Numero da casa obrigatório")
    @Column(name = "numero")
    private int numeroCasa;
    @NotBlank(message = "Campo Bairro obrigatório")
    private String bairro;
    @NotBlank(message = "Campo Cidade obrigatório")
    private String cidade;
    @NotBlank(message = "Campo Estado obrigatório")
    private String estado;
    @NotBlank(message = "Campo CEP obrigatório")
    private String cep;
}
