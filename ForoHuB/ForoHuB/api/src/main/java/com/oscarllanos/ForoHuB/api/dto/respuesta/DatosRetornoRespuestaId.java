package com.oscarllanos.ForoHuB.api.dto.respuesta;

import com.oscarllanos.ForoHuB.api.dto.topico.DatosRespuestaTopico;
import com.oscarllanos.ForoHuB.api.dto.usuario.DatosRespuestaUsuario;
import com.oscarllanos.ForoHuB.api.modelo.Respuesta;

public record DatosRetornoRespuestaId(String mensaje, DatosRespuestaTopico topico, String fechaCreacion, DatosRespuestaUsuario autor, String solucion) {

    public DatosRetornoRespuestaId(Respuesta respuesta) {
        this(respuesta.getMensaje(), new DatosRespuestaTopico(respuesta.getTopico()), respuesta.getFechaCreacion().toString(),
                new DatosRespuestaUsuario(respuesta.getAutor()), respuesta.getSolucion().toString());
    }
}
