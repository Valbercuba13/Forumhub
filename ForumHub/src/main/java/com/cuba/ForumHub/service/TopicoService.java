package com.cuba.ForumHub.service;

import com.cuba.ForumHub.dto.TopicoDto;
import com.cuba.ForumHub.dto.TopicoResponseDto;
import com.cuba.ForumHub.model.Topico;
import com.cuba.ForumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;


    public TopicoResponseDto criarTopico(TopicoDto topicoDto) {

        Topico topico = new Topico();
        topico.setTitulo(topicoDto.getTitulo());
        topico.setMensagem(topicoDto.getMensagem());
        topico.setAutor(topicoDto.getAutor());
        topico.setCurso(topicoDto.getCurso());

        topico = topicoRepository.save(topico);
        return new TopicoResponseDto(topico);
    }

    public List<TopicoResponseDto> listarTopicos() {
        return  topicoRepository.findAll().stream()
                .map(TopicoResponseDto::new)
                .collect(Collectors.toList());
    }

    public TopicoResponseDto detalharTopico(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(()-> new RuntimeException("Topico não Encontrado"));
        return new TopicoResponseDto(topico);
    }

    public TopicoResponseDto atualizarTopico(Long id, TopicoDto topicoDto) {

        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setTitulo(topicoDto.getTitulo());
        topico.setMensagem(topicoDto.getMensagem());
        topico.setAutor(topicoDto.getAutor());
        topico.setCurso(topicoDto.getCurso());

        topico = topicoRepository.save(topico);
        return new TopicoResponseDto(topico);

    }

    public void excluirTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}
