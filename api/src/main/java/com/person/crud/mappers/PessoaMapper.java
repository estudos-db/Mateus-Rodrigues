package com.person.crud.mappers;

import com.person.crud.dto.PessoaDto;
import com.person.crud.model.Pessoa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public static PessoaDto toDTO(Pessoa pessoa) {
        PessoaDto pessoaDTO = new PessoaDto();
        BeanUtils.copyProperties(pessoa, pessoaDTO, "enderecos");
        return pessoaDTO;
    }

    public static Pessoa toEntity(PessoaDto pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa, "enderecos");
        return pessoa;
    }

    public static void updateEntityFromDTO(PessoaDto pessoaDTO, Pessoa pessoa) {
        BeanUtils.copyProperties(pessoaDTO, pessoa, "id", "enderecos");
    }
}
