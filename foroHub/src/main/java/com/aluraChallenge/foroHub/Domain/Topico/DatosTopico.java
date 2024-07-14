package com.aluraChallenge.foroHub.Domain.Topico;

import java.time.LocalDateTime;

public record DatosTopico(Long id,
                          String titulo,
                          String mensaje,
                          LocalDateTime fecha,
                          Boolean status,
                          String autor,
                          String curso) {
}
