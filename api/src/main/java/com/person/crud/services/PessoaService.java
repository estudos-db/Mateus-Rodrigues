package com.person.crud.services;

import com.person.crud.dto.PessoaDto;
import com.person.crud.mappers.PessoaMapper;
import com.person.crud.models.Pessoa;
import com.person.crud.repositories.PessoaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PessoaService {


    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public List<PessoaDto> getAllPessoas() {
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
        throw new IllegalArgumentException("Pessoa não encontrada, id não esta presente no banco de dados");
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
        throw new IllegalArgumentException("Pessoa não encontrada, esse ID nao se encontra em nossa base de dados");
    }

    public void excluirPessoa(Long pessoaId) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        if (pessoaOptional.isPresent()) {
            pessoaRepository.delete(pessoaOptional.get());
        } else {
            throw new IllegalArgumentException("Pessoa nao encontrada, esse ID pode nao estar cadastrado em nosso banco de dados");
        }
    }
}
