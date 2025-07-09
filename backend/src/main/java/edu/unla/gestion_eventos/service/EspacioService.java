package edu.unla.gestion_eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.unla.gestion_eventos.model.Espacio;
import edu.unla.gestion_eventos.repository.EspacioRepository;

@Service
public class EspacioService {

    private final EspacioRepository espacioRepository;

    public EspacioService(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    public Espacio crear(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    public List<Espacio> listar() {
        return espacioRepository.findAll();
    }

    public Optional<Espacio> buscarPorId(Long id) {
        return espacioRepository.findById(id);
    }

    public Espacio actualizar(Long id, Espacio actualizado) {
        Espacio espacio = espacioRepository.findById(id).orElseThrow();
        espacio.setNombre(actualizado.getNombre());
        espacio.setCapacidad(actualizado.getCapacidad());
        espacio.setUbicacion(actualizado.getUbicacion());
        espacio.setDisponible(actualizado.getDisponible());
        return espacioRepository.save(espacio);
    }

    public void eliminar(Long id) {
        espacioRepository.deleteById(id);
    }

    public List<Espacio> listarDisponibles() {
        return espacioRepository.findByDisponibleTrue();
    }
}
