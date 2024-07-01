package com.cuba.ForumHub.model;

import jakarta.persistence.*;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String titulo;
    private String mensagem;

    private LocalDateTime dataCriacao=LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico = EstadoTopico.ABERTO;

    private String autor;
    private String curso;

}

enum EstadoTopico {
    ABERTO, FECHADO, RESOLVIDO
}

