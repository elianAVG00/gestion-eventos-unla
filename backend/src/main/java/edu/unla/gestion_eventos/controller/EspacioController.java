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

import edu.unla.gestion_eventos.model.Espacio;
import edu.unla.gestion_eventos.service.EspacioService;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    private final EspacioService espacioService;

    public EspacioController(EspacioService espacioService) {
        this.espacioService = espacioService;
    }

    @PostMapping
    public ResponseEntity<Espacio> crear(@RequestBody Espacio espacio) {
        return ResponseEntity.ok(espacioService.crear(espacio));
    }

    @GetMapping
    public List<Espacio> listar() {
        return espacioService.listar();
    }

    @GetMapping("/disponibles")
    public List<Espacio> listarDisponibles() {
        return espacioService.listarDisponibles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espacio> obtener(@PathVariable Long id) {
        return espacioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Espacio> actualizar(@PathVariable Long id, @RequestBody Espacio espacio) {
        return ResponseEntity.ok(espacioService.actualizar(id, espacio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        espacioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
