package com.facilitandogastos.project.dtos;

import jakarta.validation.constraints.NotBlank;

public record DespesaRecordDto(@NotBlank String descricao) {


}
