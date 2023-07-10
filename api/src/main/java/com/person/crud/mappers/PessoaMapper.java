package com.person.crud.mappers;

import com.person.crud.dto.PessoaDto;
import com.person.crud.models.Pessoa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public interface PessoaMapper {

    static PessoaDto toDTO(Pessoa pessoa) {
        PessoaDto pessoaDTO = new PessoaDto();
        BeanUtils.copyProperties(pessoa, pessoaDTO, "enderecos");
        return pessoaDTO;
    }

    static Pessoa toEntity(PessoaDto pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa, "enderecos");
        return pessoa;
    }

    static void updateEntityFromDTO(PessoaDto pessoaDTO, Pessoa pessoa) {
        BeanUtils.copyProperties(pessoaDTO, pessoa, "id", "enderecos");
    }
}
