package edu.unla.gestion_eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unla.gestion_eventos.model.Espacio;

public interface EspacioRepository extends JpaRepository<Espacio, Long> {
    List<Espacio> findByDisponibleTrue();
}
