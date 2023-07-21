package com.person.crud.services;

import com.person.crud.dto.PessoaDto;
import com.person.crud.models.Pessoa;
import com.person.crud.repositories.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    Pessoa pessoa;
    Pessoa pessoa2;

    PessoaDto pessoaDto;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa();
        pessoa2 = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Jonas");
        pessoa.setCpf("12356489521");

        pessoa2.setId(2L);
        pessoa2.setNome("Maria");
        pessoa2.setCpf("45678913245");

        pessoaDto = new PessoaDto();
        pessoaDto.setNome("Mateus");
        pessoaDto.setDataNascimento(LocalDate.of(1994, 7, 20));
        pessoaDto.setCpf("12456987452");
    }

    @Test
    @DisplayName("Lista todas as pessoas no banco")
    void getAllPessoas() {
        List<Pessoa> pessoas = Arrays.asList(pessoa, pessoa2);
        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<PessoaDto> pessoaDtos = pessoaService.getAllPessoas();

        assertEquals(2, pessoas.size());
        assertEquals("Jonas", pessoas.get(0).getNome());
        assertEquals("Maria", pessoas.get(1).getNome());
    }

    @Test
    @DisplayName("Retorna busca pelo id")
    void getPessoaById() {
        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        var pessoa1  =pessoaService.getPessoaById(1L);
        assertEquals("Jonas", pessoa1.getNome());
    }

    @Test
    @DisplayName("Criar Pessoa ")
    void criarPessoa() {

        pessoaDto.getNome();
        pessoaDto.getCpf();
        pessoaDto.getDataNascimento();

        Pessoa pessoaSalva = new Pessoa();
        pessoaSalva.setId(1L);
        pessoaSalva.setNome("Mateus");
        pessoaSalva.setDataNascimento(LocalDate.of(1994,7,20));
        pessoaSalva.setCpf("12456987452");

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaSalva);

        var pessoaCriada = pessoaService.criarPessoa(pessoaDto);

        assertEquals("Mateus", pessoaCriada.getNome());
        assertEquals(LocalDate.of(1994,7,20), pessoaCriada.getDataNascimento());
        assertEquals("12456987452", pessoaCriada.getCpf());
    }

    @Test
    @DisplayName("Atualiza pessoa")
    void atualizarPessoa() {
        Long pessoaId = 1L;
        pessoaDto.setId(pessoaId);
        pessoaDto.setNome("Pedro");

        when(pessoaRepository.findById(pessoaId)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        var pessoaAtualizadaDto = pessoaService.atualizarPessoa(pessoaId, pessoaDto);

        assertEquals(pessoaId, pessoaAtualizadaDto.getId());
        assertEquals("Pedro", pessoaAtualizadaDto.getNome());
    }

    @Test
    @DisplayName("Excluir pessoa")
    void excluirPessoa() {
        pessoa.getId();

        when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));

        pessoaService.excluirPessoa(pessoa.getId());

        verify(pessoaRepository, times(1)).delete(pessoa);
    }
}