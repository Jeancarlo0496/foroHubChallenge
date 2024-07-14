package com.aluraChallenge.foroHub.Domain.Topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "mensaje")
    private String mensaje;
    @Setter
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Setter
    @Column(name = "status")
    private Boolean status;
    @Column(name = "curso")
    private String curso;

    public Topico(DatosRegistroTopico datos) {
        this.id = datos.id();
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = datos.fecha();
        this.status = datos.status();
        this.curso = datos.curso();
    }

    public void actualizarTopico(DatosRegistroTopico datos) {
        this.id = datos.id();
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = datos.fecha();
        this.status = datos.status();
        this.curso = datos.curso();
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
