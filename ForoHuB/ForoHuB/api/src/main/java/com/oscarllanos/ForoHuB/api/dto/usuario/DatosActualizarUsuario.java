package com.oscarllanos.ForoHuB.api.dto.usuario;

import com.oscarllanos.ForoHuB.api.modelo.Tipo;

public record DatosActualizarUsuario(Long id, String nombre, String email, String contrasena, Tipo tipo) {
}
