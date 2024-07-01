package com.cuba.forumhub.controller;

import com.cuba.forumhub.dto.TopicoDto;
import com.cuba.forumhub.dto.TopicoResponseDto;
import com.cuba.forumhub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoResponseDto> criarTopico(@RequestBody TopicoDto topicoDto) {
        return ResponseEntity.ok(topicoService.criarTopico(topicoDto));
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseDto>> listarTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDto> detalharTopico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.detalharTopico(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDto> atualizarTopico(@PathVariable Long id, @RequestBody TopicoDto topicoDto) {
        return ResponseEntity.ok(topicoService.atualizarTopico(id, topicoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {
        topicoService.excluirTopico(id);
        return ResponseEntity.noContent().build();
    }
}
