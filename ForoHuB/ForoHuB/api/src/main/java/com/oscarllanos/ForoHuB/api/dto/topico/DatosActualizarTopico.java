package com.oscarllanos.ForoHuB.api.dto.topico;

import com.oscarllanos.ForoHuB.api.modelo.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Estado estado,
        @NotNull
        Long autorId,
        @NotNull
        Long cursoId) {
}
