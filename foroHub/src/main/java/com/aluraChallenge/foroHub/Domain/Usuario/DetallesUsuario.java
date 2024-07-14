package com.aluraChallenge.foroHub.Domain.Usuario;

public record DetallesUsuario(Long id,
                              String nombre,
                              String perfil) {
    public DetallesUsuario (Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getPerfil());
    }
}
