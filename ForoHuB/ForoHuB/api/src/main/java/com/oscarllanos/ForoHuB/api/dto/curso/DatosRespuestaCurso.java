package com.oscarllanos.ForoHuB.api.dto.curso;

import com.oscarllanos.ForoHuB.api.modelo.Curso;

public record DatosRespuestaCurso(String nombre, String categoria) {

    public DatosRespuestaCurso(Curso curso) {
        this(curso.getNombre(), curso.getCategoria());
    }
}
