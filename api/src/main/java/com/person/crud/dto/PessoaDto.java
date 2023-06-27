package com.person.crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {

    @NotBlank
    private String nome;
    private LocalDate dataNascimento;
    @NotBlank
    private String cpf;
    private List<EnderecoDto> enderecoDto;


}
