package com.aluraChallenge.foroHub.Domain.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario (@NotNull
                                   String nombre,
                                   @NotNull
                                   @Email
                                   String email,
                                   @NotNull
                                   String contraseña,
                                   @NotNull
                                   String perfil) {
}
