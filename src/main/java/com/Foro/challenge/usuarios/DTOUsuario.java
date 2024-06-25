package com.Foro.challenge.usuarios;

import jakarta.validation.constraints.NotBlank;

public record DTOUsuario(
        @NotBlank
        String login,
        @NotBlank
        String clave) {
}
