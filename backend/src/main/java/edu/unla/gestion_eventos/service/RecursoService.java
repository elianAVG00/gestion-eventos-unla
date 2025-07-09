package edu.unla.gestion_eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.unla.gestion_eventos.model.Recurso;
import edu.unla.gestion_eventos.model.TipoRecurso;
import edu.unla.gestion_eventos.repository.RecursoRepository;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public Recurso crear(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    public List<Recurso> listar() {
        return recursoRepository.findAll();
    }

    public Optional<Recurso> buscarPorId(Long id) {
        return recursoRepository.findById(id);
    }

    public Recurso actualizar(Long id, Recurso actualizado) {
        Recurso recurso = recursoRepository.findById(id).orElseThrow();
        recurso.setNombre(actualizado.getNombre());
        recurso.setTipo(actualizado.getTipo());
        recurso.setDisponible(actualizado.getDisponible());
        return recursoRepository.save(recurso);
    }

    public void eliminar(Long id) {
        recursoRepository.deleteById(id);
    }

    public List<Recurso> listarDisponibles() {
        return recursoRepository.findByDisponibleTrue();
    }

    public List<Recurso> buscarPorTipo(TipoRecurso tipo) {
        return recursoRepository.findByTipo(tipo);
    }
}
