package com.person.crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PessoaDto {

    @NotBlank
    private String nome;
    private LocalDate dataNascimento;
    @NotBlank
    private String cpf;
    private List<EnderecoDto> enderecoDto;


}
