package com.person.crud.service;


import com.person.crud.dto.PessoaDto;
import com.person.crud.mappers.PessoaMapper;
import com.person.crud.model.Pessoa;
import com.person.crud.repositories.EnderecoRepository;
import com.person.crud.repositories.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<PessoaDto> getAllPessoas(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream()
                .map(PessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDto getPessoaById(Long pessoaId) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        if (pessoaOptional.isPresent()) {
            return PessoaMapper.toDTO(pessoaOptional.get());
        }
        throw new RuntimeException("Pessoa não encontrada");
    }

    public PessoaDto criarPessoa(PessoaDto pessoaDTO) {
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return PessoaMapper.toDTO(pessoaSalva);
    }

    public PessoaDto atualizarPessoa(Long pessoaId, PessoaDto pessoaDTO) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            PessoaMapper.updateEntityFromDTO(pessoaDTO, pessoa);
            Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
            return PessoaMapper.toDTO(pessoaAtualizada);
        }
        throw new RuntimeException("Pessoa não encontrada");
    }

    public void excluirPessoa(Long pessoaId) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        if (pessoaOptional.isPresent()) {
            pessoaRepository.delete(pessoaOptional.get());
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }













}
