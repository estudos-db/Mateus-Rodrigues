package com.person.crud.controller;

import com.person.crud.dto.EnderecoDto;
import com.person.crud.services.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> getAllEnderecos() {
        List<EnderecoDto> enderecoDto = enderecoService.getAllEnderecos();
        return ResponseEntity.ok().body(enderecoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> getEnderecoById(@PathVariable("id") Long id) {
        EnderecoDto enderecoDto = enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(enderecoDto);
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> criarEndereco(@RequestBody EnderecoDto enderecoDto) {
        EnderecoDto enderecoCriado = enderecoService.criarEndereco(enderecoDto);
        return new ResponseEntity<>(enderecoCriado, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDto> atualizarEndereco(@PathVariable("id") Long id, @RequestBody EnderecoDto enderecoDto) {
        EnderecoDto enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDto);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEndereco(@PathVariable("id") Long id) {
        enderecoService.excluirEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
