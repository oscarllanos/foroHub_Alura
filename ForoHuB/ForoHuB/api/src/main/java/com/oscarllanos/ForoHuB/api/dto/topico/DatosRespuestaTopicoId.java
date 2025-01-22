package com.oscarllanos.ForoHuB.api.dto.topico;

import com.oscarllanos.ForoHuB.api.dto.curso.DatosRespuestaCurso;
import com.oscarllanos.ForoHuB.api.dto.usuario.DatosRespuestaUsuario;
import com.oscarllanos.ForoHuB.api.modelo.Topico;

public record DatosRespuestaTopicoId(Long id, String titulo, String mensaje, String fechaCreacion, String estado, DatosRespuestaUsuario autor,
                                     DatosRespuestaCurso curso) {

    public DatosRespuestaTopicoId(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(),
                topico.getEstado().toString(), new DatosRespuestaUsuario(topico.getAutor()),
                new DatosRespuestaCurso(topico.getCurso()));
    }
}
