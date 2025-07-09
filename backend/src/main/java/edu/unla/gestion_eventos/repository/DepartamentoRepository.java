package edu.unla.gestion_eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unla.gestion_eventos.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Departamento findByNombre(String nombre);
}
