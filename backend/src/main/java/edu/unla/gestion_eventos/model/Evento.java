package edu.unla.gestion_eventos.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	@Enumerated(EnumType.STRING)
	private EstadoEvento estado;
	
	@ManyToOne
	private Usuario solicitante;
	
	@ManyToOne
	private Espacio espacio;
	
	@ManyToMany
	private List<Recurso> recursos;
}
