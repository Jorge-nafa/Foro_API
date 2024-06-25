package com.Foro.challenge.dominio;

import jakarta.validation.constraints.NotBlank;

public record DatosForo(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
