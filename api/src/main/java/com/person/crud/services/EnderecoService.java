package com.person.crud.services;

import com.person.crud.dto.EnderecoDto;
import com.person.crud.exception.NotFoundException;
import com.person.crud.mappers.EnderecoMapper;
import com.person.crud.models.Endereco;
import com.person.crud.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoDto> getAllEnderecos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream()
                .map(EnderecoMapper::toDto)
                .collect(Collectors.toList());
    }

    public EnderecoDto getEnderecoById(Long id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            return EnderecoMapper.toDto(enderecoOptional.get());

        }
        throw new IllegalArgumentException("Pessoa não encontrada, id não esta presente no banco de dados");
    }

    public EnderecoDto criarEndereco(EnderecoDto enderecoDto){
        Endereco endereco = EnderecoMapper.toEntity(enderecoDto);
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return EnderecoMapper.toDto(enderecoSalvo);
    }

    public EnderecoDto atualizarEndereco(Long id, EnderecoDto enderecoDto){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get();
            EnderecoMapper.updateEntityFromDTO(enderecoDto,endereco);
            Endereco enderecoAtualizado = enderecoRepository.save(endereco);
            return EnderecoMapper.toDto(enderecoAtualizado);
        }

        throw new IllegalArgumentException("Id não encontrado ou não existente em nossa base de dados!");
    }

    public void excluirEndereco(Long id){
        Optional<Endereco> enderecoOptional = Optional.ofNullable(enderecoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereco nao encontrado")));
        if (enderecoOptional.isPresent()) {
            enderecoRepository.delete(enderecoOptional.get());
        }else {
            throw new IllegalArgumentException("Endereco nao encontrado, esse ID pode nao estar cadastrado em nosso banco de dados!");
        }
    }
}
