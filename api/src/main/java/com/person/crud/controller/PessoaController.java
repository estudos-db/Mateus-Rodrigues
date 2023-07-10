package com.person.crud.controller;

import com.person.crud.dto.PessoaDto;
import com.person.crud.services.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDto>> getAllPessoas() {
        List<PessoaDto> pessoaDtoList = pessoaService.getAllPessoas();
        return ResponseEntity.ok().body(pessoaDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> getPessoaById(@PathVariable("id") Long id) {
        PessoaDto pessoaDto = pessoaService.getPessoaById(id);
        return ResponseEntity.ok(pessoaDto);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> criarPessoa(@RequestBody PessoaDto pessoaDto) {
        PessoaDto pessoaCriada = pessoaService.criarPessoa(pessoaDto);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable("id") Long id, @RequestBody PessoaDto pessoaDto) {
        PessoaDto pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoaDto);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable("id") Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
