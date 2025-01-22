package com.oscarllanos.ForoHuB.api.dto.usuario;

import com.oscarllanos.ForoHuB.api.modelo.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email, String tipo) {

    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getTipo().toString());
    }
}
