package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que describe la gestion de la tabla en base de datos
 */
@Repository
public interface IEstadoRepository extends JpaRepository<EstadoEntity, Integer> { }
