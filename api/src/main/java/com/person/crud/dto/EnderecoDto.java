package com.person.crud.dto;

import lombok.Data;


@Data
public class EnderecoDto {
    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
