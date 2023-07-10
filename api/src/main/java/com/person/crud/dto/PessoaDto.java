package com.person.crud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PessoaDto {

    @NotBlank(message = "O nome é um campo obrigatório")
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotBlank(message = "O CPF é um campo obrigatório")
    private String cpf;
    private List<EnderecoDto> enderecoDto;
}
