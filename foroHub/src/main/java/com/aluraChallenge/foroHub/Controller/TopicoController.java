package com.aluraChallenge.foroHub.Controller;

import com.aluraChallenge.foroHub.Domain.Topico.DatosRegistroTopico;
import com.aluraChallenge.foroHub.Domain.Topico.DetallesTopico;
import com.aluraChallenge.foroHub.Domain.Topico.Topico;
import com.aluraChallenge.foroHub.Domain.Topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/topico")
@SuppressWarnings("all")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DetallesTopico> crearTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        Topico topico = new Topico(datos);
        LocalDateTime fechaActual = LocalDateTime.now();
        topico.setFecha(fechaActual);
        topico.setStatus(true);
        topico = repository.save(topico);

        DetallesTopico detallesTopico = new DetallesTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha());

        URI url = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(detallesTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DetallesTopico>> listarTopicos(@PageableDefault(size = 4) Pageable pageable) {
        Page<Topico> topicosPage = repository.findBystatusTrue(pageable);
        Page<DetallesTopico> detallesTopicoPage = topicosPage.map(DetallesTopico::new);
        return ResponseEntity.ok(detallesTopicoPage);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        Topico topico = repository.getReferenceById(datos.id());
        LocalDateTime fechaActual = LocalDateTime.now();
        topico.actualizarTopico(datos);
        topico.setFecha(fechaActual);
        topico.setStatus(true);
        repository.save(topico);
        return ResponseEntity.ok(new DetallesTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
