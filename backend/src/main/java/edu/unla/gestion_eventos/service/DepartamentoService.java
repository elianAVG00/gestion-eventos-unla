package edu.unla.gestion_eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.unla.gestion_eventos.model.Departamento;
import edu.unla.gestion_eventos.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Departamento crear(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> buscarPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento actualizar(Long id, Departamento actualizado) {
        Departamento dpto = departamentoRepository.findById(id).orElseThrow();
        dpto.setNombre(actualizado.getNombre());
        dpto.setColorVisual(actualizado.getColorVisual());
        return departamentoRepository.save(dpto);
    }

    public void eliminar(Long id) {
        departamentoRepository.deleteById(id);
    }
}
