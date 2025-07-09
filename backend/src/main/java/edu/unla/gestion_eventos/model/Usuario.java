package edu.unla.gestion_eventos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import lombok.Data;

@Entity
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        private String nombre;
        private String email;

        @Enumerated(EnumType.STRING)
        private RolUsuario rol;

        @ManyToOne
        @JoinColumn(name = "departamento_id")
        private Departamento departamento;
}
