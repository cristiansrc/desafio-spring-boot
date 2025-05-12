package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.impl;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping.IEstadoMapping;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Estado;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.EstadoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que mappea de entity a model de usuarios
 */
@Service
public class EstadoMapping implements IEstadoMapping {

    /**
     *  mapea la informacion la clase entity a la clase model
     * @param estadoEntity objeto de base de datos
     * @return objeto model
     */
    @Override
    public Estado estadoEntityToModel(EstadoEntity estadoEntity) {
        Estado estado = new Estado();
        estado.setId(estadoEntity.getId());
        estado.setNombre(estadoEntity.getNombre());
        return estado;
    }

    /**
     * mapea la informacion de una lista de estado entity a lista de model
     * @param estadoEntities lista de objetos de entity
     * @return lista de objetos model
     */
    @Override
    public List<Estado> listEstadoEntityToModel(List<EstadoEntity> estadoEntities) {
        List<Estado> estados = new ArrayList<>();
        estadoEntities.forEach(estadoEntity -> estados.add(this.estadoEntityToModel(estadoEntity)));
        return estados;
    }

    /**
     * Mapea la informacion de model a entity
     * @param estado objeto model
     * @return objeto entity
     */
    @Override
    public EstadoEntity modelToEstadoEntity(Estado estado) {
        return EstadoEntity.builder()
                .id(estado.getId())
                .nombre(estado.getNombre())
                .build();
    }
}
