package com.facilitandogastos.project.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(@NotBlank String nome, @NotBlank String login, @NotBlank String senha) {
}
