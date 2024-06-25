package com.Foro.challenge.dominio;

import jakarta.validation.constraints.NotBlank;

public record DTOActualizacion(
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
}
