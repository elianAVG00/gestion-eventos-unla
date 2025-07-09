package edu.unla.gestion_eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unla.gestion_eventos.model.Recurso;
import edu.unla.gestion_eventos.model.TipoRecurso;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    List<Recurso> findByDisponibleTrue();
    List<Recurso> findByTipo(TipoRecurso tipo);
}
