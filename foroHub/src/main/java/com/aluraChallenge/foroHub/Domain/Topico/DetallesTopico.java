package com.aluraChallenge.foroHub.Domain.Topico;

import java.time.LocalDateTime;

public record DetallesTopico(Long id,
                             String titulo,
                             String mensaje,
                             LocalDateTime fecha) {
    public DetallesTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha());
    }
}
