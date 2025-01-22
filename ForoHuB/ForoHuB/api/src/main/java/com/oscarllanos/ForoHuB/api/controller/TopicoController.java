package com.oscarllanos.ForoHuB.api.controller;

import com.oscarllanos.ForoHuB.api.dto.topico.*;
import com.oscarllanos.ForoHuB.api.modelo.Curso;
import com.oscarllanos.ForoHuB.api.modelo.Topico;
import com.oscarllanos.ForoHuB.api.modelo.Usuario;
import com.oscarllanos.ForoHuB.api.repository.CursoRepository;
import com.oscarllanos.ForoHuB.api.repository.TopicoRepository;
import com.oscarllanos.ForoHuB.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrar(@RequestBody @Valid DatosRegistroTopico datosRegistro, UriComponentsBuilder uri) {
        Usuario autor = usuarioRepository.getReferenceById(datosRegistro.autorId());
        Curso curso = cursoRepository.getReferenceById(datosRegistro.cursoId());
        Topico topico = topicoRepository.save(new Topico(datosRegistro, autor, curso));
        DatosRespuestaTopico datosRespuesta = new DatosRespuestaTopico(topico);
        URI url = uri.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar(@PageableDefault(size = 10)Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopicoId> retornaDatos(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopicoId(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizar(@RequestBody @Valid DatosActualizarTopico datosActualizar) {
        Usuario autor = usuarioRepository.getReferenceById(datosActualizar.autorId());
        Curso curso = cursoRepository.getReferenceById(datosActualizar.cursoId());
        Topico topico = topicoRepository.getReferenceById(datosActualizar.id());
        topico.actualizarDatos(datosActualizar, autor, curso);
        return ResponseEntity.ok( new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        //topicoRepository.delete(topico);
        topico.cerrarTopico();
        return ResponseEntity.noContent().build();
    }
}
