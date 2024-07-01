package com.cuba.ForumHub.dto;
import com.cuba.ForumHub.model.Topico;
import lombok.Data;

@Data
public class TopicoResponseDto {
    private Long Id;
    private String titulo;
    private String mensagem;
    private String autor;
    private String curso;


    public TopicoResponseDto(Topico topico) {

        this.Id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.autor = topico.getAutor();
        this.curso = topico.getCurso();
    }
}
