package edu.unla.gestion_eventos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unla.gestion_eventos.model.Recurso;
import edu.unla.gestion_eventos.model.TipoRecurso;
import edu.unla.gestion_eventos.service.RecursoService;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @PostMapping
    public ResponseEntity<Recurso> crear(@RequestBody Recurso recurso) {
        return ResponseEntity.ok(recursoService.crear(recurso));
    }

    @GetMapping
    public List<Recurso> listar() {
        return recursoService.listar();
    }

    @GetMapping("/disponibles")
    public List<Recurso> listarDisponibles() {
        return recursoService.listarDisponibles();
    }

    @GetMapping("/tipo/{tipo}")
    public List<Recurso> buscarPorTipo(@PathVariable TipoRecurso tipo) {
        return recursoService.buscarPorTipo(tipo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> obtener(@PathVariable Long id) {
        return recursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> actualizar(@PathVariable Long id, @RequestBody Recurso recurso) {
        return ResponseEntity.ok(recursoService.actualizar(id, recurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        recursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
