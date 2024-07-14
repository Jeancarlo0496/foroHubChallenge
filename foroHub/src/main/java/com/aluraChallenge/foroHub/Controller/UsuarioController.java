package com.aluraChallenge.foroHub.Controller;

import com.aluraChallenge.foroHub.Domain.Usuario.DatosRegistroUsuario;
import com.aluraChallenge.foroHub.Domain.Usuario.DetallesUsuario;
import com.aluraChallenge.foroHub.Domain.Usuario.Usuario;
import com.aluraChallenge.foroHub.Domain.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
@SuppressWarnings("all")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody DatosRegistroUsuario datos, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(datos);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetallesUsuario(usuario));

    }
}
