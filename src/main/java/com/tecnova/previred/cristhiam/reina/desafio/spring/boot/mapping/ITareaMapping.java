package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.mapping;

import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.model.Tarea;
import com.tecnova.previred.cristhiam.reina.desafio.spring.boot.repository.entity.TareaEntity;

import java.util.List;

/**
 * Inteface que describe la funcionalidad del mappeo de tareas
 */
public interface ITareaMapping {

    /**
     * mapea la informacion la clase entity a la clase model
     * @param tareaEntity objeto de base de datos
     * @return objeto model
     */
    Tarea tareaEntityToModel(TareaEntity tareaEntity);

    /**
     * mapea la informacion de una lista de estado entity a lista de model
     * @param entities lista de objetos de entity
     * @return lista de objetos model
     */
    List<Tarea> listTareaEntityToModel(List<TareaEntity> entities);

    /**
     * Mapea la informacion de model a entity
     * @param tarea objeto model
     * @return objeto entity
     */
    TareaEntity modelToTareaEntity(Tarea tarea);
}
