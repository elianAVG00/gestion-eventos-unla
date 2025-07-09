package edu.unla.gestion_eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unla.gestion_eventos.model.Evento;
import edu.unla.gestion_eventos.model.EstadoEvento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByDepartamentoNombre(String nombreDepartamento);

    List<Evento> findByEstado(EstadoEvento estado);
}
