package com.aluraChallenge.foroHub.Domain.Topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
public record DatosRegistroTopico( @NotNull
                                   Long id,
                                   @NotNull
                                   String titulo,
                                   @NotNull
                                   String mensaje,
                                   LocalDateTime fecha,
                                   Boolean status,
                                   @NotNull
                                   String curso){
}
