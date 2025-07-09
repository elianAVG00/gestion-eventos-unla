package edu.unla.gestion_eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unla.gestion_eventos.model.Evento;
import edu.unla.gestion_eventos.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> crear(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.crearEvento(evento));
    }

    @GetMapping
    public List<Evento> listar() {
        return eventoService.listarEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtener(@PathVariable Long id) {
        return eventoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.actualizarEvento(id, evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
