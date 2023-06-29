package com.person.crud.mappers;

import com.person.crud.dto.EnderecoDto;
import com.person.crud.model.Endereco;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public interface EnderecoMapper {

    static EnderecoDto toDto(Endereco endereco) {
        EnderecoDto enderecoDto = new EnderecoDto();
        BeanUtils.copyProperties(endereco, enderecoDto);
        return enderecoDto;
    }

    static Endereco toEntity(EnderecoDto enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return endereco;
    }

    static void updateEntityFromDTO(EnderecoDto enderecoDTO, Endereco endereco) {
        BeanUtils.copyProperties(enderecoDTO, endereco, "id");
    }


}
