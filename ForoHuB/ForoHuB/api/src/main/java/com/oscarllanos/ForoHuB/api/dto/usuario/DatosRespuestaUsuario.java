package com.oscarllanos.ForoHuB.api.dto.usuario;

import com.oscarllanos.ForoHuB.api.modelo.Usuario;

public record DatosRespuestaUsuario(String nombre, String email, String tipo) {

    public DatosRespuestaUsuario(Usuario usuario) {
        this(usuario.getNombre(), usuario.getEmail(), usuario.getTipo().toString());
    }
}
