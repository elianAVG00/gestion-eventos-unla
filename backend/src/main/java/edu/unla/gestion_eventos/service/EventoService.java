package edu.unla.gestion_eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unla.gestion_eventos.model.Evento;
import edu.unla.gestion_eventos.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento actualizarEvento(Long id, Evento eventoActualizado) {
        Evento evento = eventoRepository.findById(id).orElseThrow();
        evento.setNombre(eventoActualizado.getNombre());
        // más setters...
        return eventoRepository.save(evento);
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
