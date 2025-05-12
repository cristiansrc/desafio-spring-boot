package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que mapea la estructura de la tabla en base de datos
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tarea")
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private EstadoEntity estado;
}
