package com.aluraChallenge.foroHub.Domain.Usuario;

public record DatosUsuario(Long id,
                String nombre,
                String email,
                String contraseña,
                String perfil) {
}
