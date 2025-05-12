package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping;


import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Estado;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.EstadoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Inteface que describe la funcionalidad del mappeo de estados
 */
public interface IEstadoMapping {

    /**
     *  mapea la informacion la clase entity a la clase model
     * @param estadoEntity objeto de base de datos
     * @return objeto model
     */
    Estado estadoEntityToModel(EstadoEntity estadoEntity);

    /**
     * mapea la informacion de una lista de estado entity a lista de model
     * @param estadoEntities lista de objetos de entity
     * @return lista de objetos model
     */
    List<Estado> listEstadoEntityToModel(List<EstadoEntity> estadoEntities);

    /**
     * Mapea la informacion de model a entity
     * @param estado objeto model
     * @return objeto entity
     */
    EstadoEntity modelToEstadoEntity(Estado estado);
}
