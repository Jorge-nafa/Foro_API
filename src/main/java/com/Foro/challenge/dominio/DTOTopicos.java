package com.Foro.challenge.dominio;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record DTOTopicos(
         Long id,
         String titulo,
         String mensaje,
         String autor,
         String curso,
         Boolean status,
         LocalDate fechaCreacion
) {
    public DTOTopicos(Foro foro) {
        this(foro.getId(), foro.getTitulo(), foro.getMensaje(), foro.getAutor(),
                foro.getCurso(), foro.getStatus(),foro.getFechaCreacion());
    }
}
